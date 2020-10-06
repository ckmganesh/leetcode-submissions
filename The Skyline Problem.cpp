class max_heap {
    vector<int> index; // id -> index into values
    vector<pair<int, int>> values; // first is the height, second is id
    int size;
    
    void swap_node(int index1, int index2) {
        swap(index[values[index1].second], index[values[index2].second]);
        swap(values[index1], values[index2]);
    }
    
    // idx for values vector
    void heapify_up(int idx) {
        while (idx != 0) {
            int parent = (idx - 1) / 2;
            if (values[idx].first <= values[parent].first)
                return;
            
            swap_node(idx, parent);
            idx = parent;
        }
    }
    
    // idx for values vector
    void heapify_down(int idx) {
        while (true) {
            int l = idx * 2 + 1;
            int r = idx * 2 + 2;
            
            int largest = idx;
            
            if (l < size && values[l].first > values[idx].first)
                largest = l;
            
            if (r < size && values[r].first > values[largest].first)
                largest = r;
            
            if (largest == idx)
                return;
            
            swap_node(largest, idx);
            idx = largest;
        }
    }
    
public:
    max_heap(int s): index(s), values(s), size(0) {}
    
    // O(1)
    int max() const {
        return values[0].first;
    }
    
    // O(logn)
    void insert(int height, int id) {
        index[id] = size;
        values[size] = {height, id};
        ++size;
        heapify_up(index[id]);
    }
    
    // O(logn)
    void remove(int id) {
        int index_to_remove = index[id];
        swap_node(index_to_remove, size - 1);
        --size;
        // heapify_up(index_to_remove);
        heapify_down(index_to_remove);
    }
};

class Solution {
public:
    // Time: O(nlogn)
    // Space: O(n)
    // entering and leaving point with the same x, process the entering point first -> set height of entering point to a negative value, and set height of leaving point to a positive value
    // entering point with same x, process the highest point first -> set height of entering point to a negative value
    // leaving point with same x, process the lowest point first -> set height of leaving point to a positive value
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        vector<vector<int>> res;
        vector<Point> points;
        for (int i = 0; i < buildings.size(); ++i) {
            const auto & b = buildings[i];
            points.push_back(Point{i + 1, b[0], -b[2]});
            points.push_back(Point{i + 1, b[1], b[2]});
        }
        sort(points.begin(), points.end());
        max_heap heap(buildings.size() + 1); // plus one for the zero
        heap.insert(0, 0); // height 0, id 0
        int pre = 0, cur = 0;
        for (auto & p : points) {
            if (p.h < 0) {
                if (-p.h > heap.max())
                    res.push_back({p.x, -p.h});
                heap.insert(-p.h, p.id);
            } else {
                heap.remove(p.id);
                if (p.h > heap.max())
                    res.push_back({p.x, heap.max()});
            }
        }
        return res;
    }
    
private:
    struct Point {
        int id;
        int x;
        int h;

        bool operator<(const Point & rhs) const {
            if (x == rhs.x) {
                return h < rhs.h;
            }
            return x < rhs.x;
        }
    };
};
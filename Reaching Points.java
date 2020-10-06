class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
if(ty<sy || tx<sx){return false;}
if(sx==tx){
if((ty-sy)%sx==0){return true;}
else{return false;}
}
if(sy==ty){
if((tx-sx)%sy==0){return true;}
else{return false;}
}
while(tx>=sx && ty>=sy){
if(tx>ty){tx-=ty;}
else{ty-=tx;}
}
return (tx+ty==sx && ty==sy) || (tx==sx && ty+tx==sy);
}
}
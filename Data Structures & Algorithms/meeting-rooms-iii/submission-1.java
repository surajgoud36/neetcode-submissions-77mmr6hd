record Room(int endTime,int count,int roomNumber){}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,Comparator.comparingInt((int[] k)->k[0]).thenComparingInt(k->k[1]));
        int max_room=0,max_room_count=0;
        PriorityQueue<Room> pq=new PriorityQueue<>(Comparator.comparingInt(Room::endTime).thenComparingInt(Room::roomNumber));
        PriorityQueue<Room> unused = new PriorityQueue<>(Comparator.comparingInt(Room::roomNumber));
        for(int i=0;i<n;i++){
            unused.add(new Room(0,0,i));
        }
        for(int[] meeting:meetings){
            while(!pq.isEmpty() && pq.peek().endTime()<=meeting[0]){
                Room room = pq.poll();
                unused.add(new Room(0,room.count(),room.roomNumber));
            }
            if(!unused.isEmpty()){
                Room room = unused.poll();
                pq.add(new Room(meeting[1],room.count()+1,room.roomNumber()));

                 if(max_room_count<room.count()+1){
                max_room=room.roomNumber();
                max_room_count=room.count()+1;
            }
            else if(max_room_count==room.count()+1 && max_room>room.roomNumber()){
                max_room=room.roomNumber();
                max_room_count=room.count()+1;
            }
            continue;
            }
            Room next=pq.poll();
           // System.out.println("roomNo: "+next.roomNumber());
            int duration=meeting[1]-meeting[0];
            int endtime=Math.max(meeting[0],next.endTime())+duration;
            pq.add(new Room(endtime,next.count()+1,next.roomNumber()));
            if(max_room_count<next.count()+1){
                max_room=next.roomNumber();
                max_room_count=next.count()+1;
            }
            else if(max_room_count==next.count()+1 && max_room>next.roomNumber()){
                max_room=next.roomNumber();
                max_room_count=next.count()+1;
            }
        }
        return max_room;
    }
}
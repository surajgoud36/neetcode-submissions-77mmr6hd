record Pair(int index,int time){}
record IPair(int[] task,int originalIndex){}
class Solution {
    PriorityQueue<Pair> pq;
    public int[] getOrder(int[][] tasks) {
       // Arrays.sort(tasks,(a,b)-> Integer.compare(a[0],b[0]));
        pq=new PriorityQueue<>(Comparator.comparingInt(Pair::time).thenComparing(Pair::index));
        List<IPair> mTasks=new ArrayList<>();
        for(int j=0;j<tasks.length;j++){
            mTasks.add(new IPair(tasks[j],j));
        }
        mTasks.sort(Comparator.comparingInt(p->p.task()[0]));
       // System.out.println(mTasks);
        int[] res=new int[tasks.length];
        int ri=0;
        int i=0;
        int currTime = mTasks.get(0).task()[0];
        while(i<mTasks.size()){
            
            i=addTask(currTime,i,mTasks);
           

           
            if(!pq.isEmpty()){
                Pair temp=pq.poll();
               
                res[ri++]=temp.index();
                currTime+=temp.time();
            }
            else{
                if(i<mTasks.size())
                    currTime=mTasks.get(i).task()[0];
            }
            
        }

        while(!pq.isEmpty()){
            Pair temp=pq.poll();
               
                res[ri++]=temp.index();
                currTime+=temp.time();
                }
            
        
        return res;
    }

    public int addTask(int currTime,int index,List<IPair> mTasks){
        while(index<mTasks.size() && mTasks.get(index).task()[0] <=currTime){
            pq.add(new Pair(mTasks.get(index).originalIndex(),mTasks.get(index).task()[1] ));
            index++;
        }
        return index;
    }
}
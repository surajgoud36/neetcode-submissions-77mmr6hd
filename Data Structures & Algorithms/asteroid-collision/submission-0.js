class Solution {
    /**
     * @param {number[]} asteroids
     * @return {number[]}
     */
    asteroidCollision(asteroids) {
        const stack = [];
        for(const ele of asteroids){
            if(stack.length === 0 || ele>0){
                stack.push(ele);
                continue;
            }
            let flag=true;
            while(stack.length>0 && stack[stack.length-1]>0){
                if(stack[stack.length-1]>Math.abs(ele)){
                    flag=false;
                    break;
                }
                else if(stack[stack.length-1] === Math.abs(ele) ){
                    stack.pop();
                    flag=false;
                    break;
                }else{
                    stack.pop();
                }
            }
            if(flag)
                stack.push(ele);
        }
        return stack;
    }
}

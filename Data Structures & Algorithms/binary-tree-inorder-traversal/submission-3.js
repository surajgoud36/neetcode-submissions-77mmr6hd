/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     constructor(val = 0, left = null, right = null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * @param {TreeNode} root
     * @return {number[]}
     */
    inorderTraversal(root) {
        if(!root)
            return [];
        const stack = [];
        let curr=root;
        const res=[];
        while(curr || stack.length){
            if(curr){
                stack.push(curr);
                curr=curr.left;
            }
            else{
                curr=stack.pop();
                res.push(curr.val);
                curr=curr.right;
            }
        }
        return res;
    }
}

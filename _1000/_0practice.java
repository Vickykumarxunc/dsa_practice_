package _1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0practice{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static ArrayList<Integer> reverse_level_order_traversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        Stack<Integer> st = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            st.push(node.data);
            if(node.right != null){
                q.add(node.right);
            }
            if(node.left != null){
                q.add(node.left);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
    public static ArrayList<Integer> level_order_traversal(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        while(!q.isEmpty()){
            Node node = q.remove();
            list.add(node.data);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        return list;
    }
    public static ArrayList<ArrayList<String>> group_anagram(String arr[] , int n){
         HashMap<String , ArrayList<String>> map = new HashMap<>();
         for(int i = 0; i<n; i++){
            int freq[] = new int[26];
            String s = arr[i];
            for(int j = 0; j<s.length(); j++){
                freq[s.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int k = 0; k<26; k++){
                key.append(freq[k]).append('#');
            }
            if(!map.containsKey(key.toString())){
                map.put(key.toString() , new ArrayList<>());
            }
            map.get(key.toString()).add(s);
         }
         return new ArrayList<>(map.values());
    }
    public static String remove_duplicate_from_String(String str){
        int n = str.length();
        boolean visited[] = new boolean[26];
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<n; i++){
            char ch = str.charAt(i);
            if(visited[ch - 'a'] == false){
                ans.append(ch);
                visited[ch - 'a'] = true;
            }
        }
        return new String(ans);
    }
    public static Node delete_middle_of_string(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
    public static ArrayList<Integer> postorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        find_post_order(root , list);
        return list;
    }
    public static void find_post_order(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        find_post_order(root.left , list);
        find_post_order(root.right , list);
        list.add(root.data);
    }
    public static class info1{
        boolean isbst;
        int max;
        int min;
        int size;
        int largest;
        info1(boolean isbst , int max , int min , int size , int largest){
            this.isbst = isbst;
            this.max = max;
            this.min = min;
            this.size = size;
            this.largest = largest;
        }
    }
    public static int largest_bst_in_binarytree(Node root){
        return solve1(root).largest;
    }
    public static info1  solve1(Node root){
        if(root == null){
            return new info1(true , Integer.MIN_VALUE , Integer.MAX_VALUE , 0 , 0);
        }
        info1 left = solve1(root.left);
        info1 right = solve1(root.right);
        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int current_size = left.size + right.size + 1;
            int curr_min = Math.min(root.data , left.min);
            int curr_max = Math.max(root.data , right.max);
            int largest = Math.max(current_size , Math.max(left.largest , right.largest));
            return new info1(true , curr_min , curr_max , current_size , largest);
        }
        int largest = Math.max(left.largest , right.largest);
        return new info1(false , 0 , 0 , 0 , largest);
    }
    public static class info2{
        boolean isbst;
        int min;
        int max;
        int sum;
        int max_sum;
        info2(boolean isbst , int min , int max , int sum , int max_sum){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.max_sum = max_sum;
        }
    }
    public static int maximum_sum_bst(Node root){
        return solve2(root).max_sum;
    }
    public static info2 solve2(Node root){
        if(root == null){
            return new info2(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0 , 0);
        }
        info2 left = solve2(root.left);
        info2 right = solve2(root.right);
        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int current_sum = left.sum + right.sum + root.data;
            int min = Math.min(root.data , left.min);
            int max = Math.max(root.data , right.max);
            int max_sum = Math.max(current_sum , Math.max(left.max_sum , right.max_sum));
            return new info2(true , min , max , current_sum , max_sum);
        }
        int max_sum = Math.max(left.max_sum , right.max_sum);
        return new info2(false , 0 , 0 , 0 , max_sum);
    }
    public static class info3{
        boolean isbst;
        int min;
        int max;
        int count;
        info3(boolean isbst , int min , int max , int count){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.count = count;
        }
    }
    public static int count(Node root){
        return solve3(root).count;
    }
    public static info3 solve3(Node root){
        if(root == null){
            return new info3(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }
        info3 left = solve3(root.left);
        info3 right = solve3(root.right);
        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int count = 1 + left.count + right.count;
            int min = Math.min(root.data , left.min);
            int max = Math.max(root.data , right.max);
            return new info3(true , min , max , count);
        }
        int count = left.count + right.count;
        return new info3(false , 0 , 0 , count);
    }
    public static ArrayList<Integer> merge_two_bst(Node root1 , Node root2){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node curr1 = root1;
        Node curr2 = root2;
        ArrayList<Integer> list = new ArrayList<>();
        while(curr1 != null || curr2 != null || !st1.isEmpty() || !st2.isEmpty()){
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.left;
            }
            if(!st1.isEmpty() && !st2.isEmpty()){
                if(st1.peek().data <= st2.peek().data){
                    list.add(st1.peek().data);
                    curr1 = st1.pop().right;
                }
                else{
                    list.add(st2.peek().data);
                    curr2 = st2.pop().right;
                }
            }
            else if(!st1.isEmpty()){
                list.add(st1.peek().data);
                curr1 = st1.pop().right;
            }
            else{
                list.add(st2.peek().data);
                curr2 = st2.pop().right;
            }
        }
        return list;
    }
    public static int ceil_in_bst(Node root , int key){
        if(root == null){
            return -1;
        }
        int ceil = -1;
        while(root != null){
            if(root.data >= key){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;
    }
    public static int floor_in_bst(Node root , int key){
        if(root == null){
            return -1;
        }
        int floor = -1;
        while(root != null){
            if(root.data <= key){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return floor;
    }
    public static boolean pair_sum_in_bst(Node root , int target){
        if(root == null){
            return false;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node curr1 = root;
        Node curr2 = root;
        while(curr1 != null || curr2 != null || !st1.isEmpty() || !st2.isEmpty()){
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.right;
            }
            if(st1.isEmpty() || st2.isEmpty()){
                return false;
            }
            if(st1.peek().data == st2.peek().data){
                return false;
            }
            int sum = st1.peek().data + st2.peek().data;
            if(sum == target){
                return true;
            }
            else if(sum < target){
                Node temp = st1.pop();
                curr1 = temp.right;
            }
            else{
                Node temp = st2.pop();
                curr2 = temp.left;
            }
        }
        return false;
    } 
    public static int count_pair_sum(Node root1 , Node root2 , int target){
         Stack<Node> st1 = new Stack<>();
         Stack<Node> st2 = new Stack<>();
         Node curr1 = root1;
         Node curr2 = root2;
         int count = 0;
         while(curr1 != null || curr2 != null || !st1.isEmpty() || !st2.isEmpty()){
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.right;
            }
            if(st1.isEmpty() || st2.isEmpty()){
                break;
            }
            int sum = st1.peek().data + st2.peek().data;
            if(sum == target){
                count++;
                curr1 = st1.pop().right;
                curr2 = st2.pop().left;
            }
            else if(sum < target){
                curr1 = st1.pop().left;
            }
            else{
                curr2 = st2.pop().right;
            }
         }
         return count;
    }
    public static ArrayList<Integer> common_in_bst(Node root1 , Node root2){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr1 = root1;
        Node curr2 = root2;
        while(curr1 != null || curr2 != null || !st1.isEmpty() || ! st2.isEmpty()){
            while(curr1 != null){
                st1.push(curr1);
                curr1 = curr1.left;
            }
            while(curr2 != null){
                st2.push(curr2);
                curr2 = curr2.left;
            }
            if(st1.isEmpty() || st2.isEmpty()){
                break;
            }
            if(st1.peek().data == st2.peek().data){
                list.add(st1.peek().data);
                curr1 = st1.pop().right;
                curr2 = st2.pop().right;
            }
            else if(st1.peek().data < st2.peek().data){
                curr1 = st1.pop().right;
            }
            else{
                curr2 = st2.pop().right;
            }
        }
        return list;
    }
    public static Node insert_in_sorted_list(Node head , int key){
        Node newNode = new Node(key);
        if(head == null){
            head = newNode;
            return head;
        }
        // insert at first 
        if(key <= head.data){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){

            // insert at middle 
            if(temp.data > key){
                prev.next = newNode;
                newNode.next = temp;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        // insert at the last 
        if(temp == null){
            prev.next = newNode;
        }
        return head;
    }
    public static ArrayList<Integer> iterative_inorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            Node temp = st.pop();
            list.add(temp.data);
            curr = temp.right;
        }
        return list;
    }
    public static ArrayList<Integer> iterative_preorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node temp = st.pop();
            list.add(temp.data);
            if(temp.right != null){
                st.push(temp.right);
            }if(temp.left != null){
                st.push(temp.left);
            }
        }
        return list;
    }
    public static ArrayList<Integer> iterative_post_order_using_two_stack(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty() || !st2.isEmpty()){
            Node temp = st1.pop();
            st2.push(temp);
            if(temp.left != null){
                st1.push(temp.left);
            }
            if(temp.right != null){
                st1.push(temp.right);
            }
            
        }
        while(!st2.isEmpty()){
            list.add(st2.pop().data);
        }
        return list;
    }
    public static ArrayList<Integer> post_order_using_one_stack(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node last_visit = null;
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            Node temp = st.peek();
            if(temp.right != null && temp.right != last_visit){
                curr = temp.right;
            }
            else{
                list.add(temp.data);
                last_visit = st.pop();
            }
        }
        return list;
    }
    public static ArrayList<Integer> morris_traversal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.data);
                curr = curr.right;
            }
            else{
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right ==  null){
                    pred.right = curr;
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    list.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return list;
    }
    public static ArrayList<Integer> morris_traversal_preorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.data);
                curr = curr.right;
            }
            else{
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    list.add(curr.data);
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return list;
    }
    public static Node swap_kth_node(Node head , int k){
        if(head == null || head.next == null){
            return head;
        }
        int n = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        if(2 * k - 1 == n){
            return head;
        }
        if(k > n){
            return head;
        }
        Node x = head;
        Node prev_x = null;
        Node y = head;
        Node prev_y = null;
        for(int i = 1; i<n - k + 1; i++){
            prev_y = y;
            y = y.next;
        }
        for(int i = 1; i<k; i++){
            prev_x = x;
            x = x.next;
        }
        if(prev_x != null){
            prev_x.next = y;
        }
        if(prev_y != null){
            prev_y.next = x;
        }
        temp  = x.next;
        x.next = y.next;
        y.next = temp;
        
        if(k == 1){
            head = y;
        }
        if(k == n){
            head = x;
        }
        return head;
    }
    public static Node construct_bst_from_preorder(int preorder[] , int n){
        int idx[] = new int[]{0};
        Node root = create_preorder_to_bst(preorder , idx , Integer.MIN_VALUE , Integer.MAX_VALUE);
        return root;
    }
    public static Node create_preorder_to_bst(int preorder[] , int idx[] , int min , int max){
        if(idx[0]  >= preorder.length){
            return null;
        }
        int value = preorder[idx[0]];
        if(value < min && value > max){
            return null;
        }
        Node root = new Node(value);
        idx[0]++;

        root.left = create_preorder_to_bst(preorder, idx, min , root.data);
        root.right = create_preorder_to_bst(preorder, idx, root.data, max);
        return root;
    }
    public static Node construct_bst_from_post_order(int postorder[] , int n){
        int idx[] = new int[n - 1];
        return create_bst(postorder , idx , Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    public static Node create_bst(int postorder[] , int idx[] , int min , int max){
        if(idx[0] < 0){
            return null;
        }
        int value = postorder[idx[0]];
        if(value < min && value > max){
            return null;
        }
        Node root = new Node(value);
        idx[0]--;
        root.right = create_bst(postorder, idx, root.data, max);
        root.left = create_bst(postorder, idx, min, root.data);
        return root;
    }
    public static boolean valid_preorder(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i] < min){
                return false;
            }
            while( !st.isEmpty() && arr[i] > st.peek()){
                min = st.pop();
            }
            st.push(arr[i]);
        }
        return true;
    }
    public static boolean valid_post_order(int arr[] , int n){
        Stack<Integer> st = new Stack<>();
        int max = Integer.MAX_VALUE;
        for(int i = n - 1; i>= 0; i--){
            if(arr[i] > max){
                return false;
            }
            while(!st.isEmpty() && arr[i] < st.peek()){
                max = st.pop();
            }
            st.push(arr[i]);
        }
        return true;
    }
    public static String largest_number(int n , int sum){
        if(sum > n * 9){
            return "-1";
        }
        if(sum == 0){
            if(n == 1){
                return "0";
            }
            return "-1";
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<n; i++){
            if(sum >= 9){
                s.append(9);
                sum -= 9;
            }
            else{
                s.append(sum);
                sum = 0;
            }
        }
        return new String(s);
    }
    public static int first_non_repeating_element(int arr[] , int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        for(int i = 0; i<n; i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return -1;
    }
    public static boolean root_to_leaf_path_sum(Node root , int target){
        return has_path_sum(root , target);
    }
    public static boolean has_path_sum(Node root , int target){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(target == 0){
                return true;
            }
        }
        return has_path_sum(root.left , target - root.data) || has_path_sum(root.right , target - root.data);
    }
    public static char most_frequent_character(String str , int n){
        int freq[] = new int[26];
        for(int i= 0; i<n; i++){
            freq[str.charAt(i) - 'a']++;
        }
        int index = 0;
        int max = -1;
        for(int i = 0; i<n; i++){
            if(freq[i] > max){
                max = freq[i];
                index = i;
            }
        }
        return (char)(index + 'a');
    }
    public static Node pair_wiseSwap(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head;
        Node forw = null;
        Node prev = null;
        Node temp = null;
        while(curr != null){
            forw  = curr.next;
            temp = forw.next;

            if(prev == null){
                head = forw;
            }
            else{
                prev.next = forw;
            }
            forw.next = curr;
            curr.next = forw;
            prev = curr;
            curr = temp;
        }
        return head;
    }
    public static boolean leaves_at_same_level_or_not(Node root){
        return check_same_level_or_not(root , 1 , 1);
    }
    public static boolean check_same_level_or_not(Node root , int leaf_level , int level){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            if(leaf_level == 0){
                leaf_level = level;
            }
            else{
                return leaf_level != level;
            }
        }
        return check_same_level_or_not(root.left , leaf_level , level + 1) && check_same_level_or_not(root.right , leaf_level , level + 1);
    }
    public static void segregate_01(int arr[] , int n){
        int left = 0;
        int right = n - 1;
        while(left < right){
            while(arr[left] == 0){
                left++;
            }
            while(arr[right] == 1){
                right--;
            }
            if(arr[left] == 1 && arr[right] == 1){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    public static int more_than_nk(int arr[] , int n , int k){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            if(map.get(arr[i]) > n/k){
                count++;
            }
        }
        return count;
    }
    public static int count_zero(int arr[] , int n){
        int low = 0;
        int high = n - 1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == 0){
                ans = mid;
                high = mid -1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return ans == 0 ? 0 : n - ans;
    }
    public static int longest_subarray_with_equal_zero_one(int arr[] , int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int max_length = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i] == 0 ? -1 : arr[i];
            if(sum == 0){
                max_length = i + 1;
            }
            if(map.containsKey(sum)){
                max_length = Math.max(max_length , i - map.get(sum) + 1);
            }
            map.put(sum , i);
        }
        return max_length;
    }
    public static int count_subarray_with_equal_zero_one(int arr[] , int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i] == 0 ? -1 : arr[i];
            if(sum == 0){
                count++;
            }
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            else{
                map.put(sum , map.getOrDefault(sum , 0) + 1);
            }
        }
        return count;
    }
    public static void transpose_matrix(int matrix[][]){
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0; i<n; i++){
            for(int j = i; j<m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static boolean palindrome_number(int n){
        int m = n;
        int rev = 0;
        while(m != 0){
            int rem = m % 10;
            rev = rev * 10 + rem;
            m = m/10;
        }
        return rev == n;
    }
    


    

    public static void main(String[] args) {
    }
}
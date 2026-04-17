
import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import javax.swing.colorchooser.ColorSelectionModel;

public class practice {
    public static int missing_element(int arr[], int n) {
        int m = n + 1;
        int total_sum = (m * (m + 1)) / 2;
        for (int i = 0; i < n; i++) {
            total_sum -= arr[i];
        }
        int missing_element = total_sum;
        return missing_element;
    }

    public static int second_largest(int arr[], int n) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2 && arr[i] != max1) {
                max2 = arr[i];
            }
        }
        return max2;
    }

    public static ArrayList<Integer> leader(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int leader = arr[n - 1];
        list.add(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > leader) {
                leader = arr[i];
                list.add(leader);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static ArrayList<Integer> duplicate_element(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                list.add(arr[i]);
            } else {
                arr[index] = -1 * arr[index];
            }
        }
        return list;
    }

    public static boolean balanced_parenthesis(String str, int n) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else if ((ch == ')' && st.peek() != '(') ||
                        (ch == '}' && st.peek() != '{') || (ch == ']' && st.peek() != '[')) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

    public static int equilibrium_point(int arr[], int n) {
        int suffix_sum = 0;
        for (int i = 0; i < n; i++) {
            suffix_sum += arr[i];
        }
        int prefix_sum = 0;
        for (int i = 0; i < n; i++) {
            suffix_sum -= arr[i];
            if (prefix_sum == suffix_sum) {
                return i;
            }
            prefix_sum += arr[i];
        }
        return -1;
    }

    public static boolean binary_search_iterative(int arr[], int n, int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static boolean binary_serach_recursive(int arr[], int low, int high, int target) {
        if (low > high) {
            return false;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] < target) {
            return binary_serach_recursive(arr, mid + 1, high, target);
        } else {
            return binary_serach_recursive(arr, low, mid - 1, target);
        }
    }

    public static ArrayList<Integer> missing_repeating(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int missing = -1;
        int repeating = -1;
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] > 0) {
                arr[index] = -1 * arr[index];
            } else {
                repeating = Math.abs(arr[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        list.add(repeating);
        list.add(missing);
        return list;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> left_view(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node node = q.remove();
                if (i == 0) {
                    list.add(node.data);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return list;
    }

    public static int floor_in_sorted_array(int arr[], int n, int target) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> bfs_on_graph(ArrayList<ArrayList<Integer>> graph, int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[v];
        ArrayList<Integer> list = new ArrayList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            list.add(node);

            for (int neighbour : graph.get(node)) {
                if (visited[neighbour] == false) {
                    q.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        return list;
    }

    public static int count_digit(int n) {
        int m = n;
        int count = 0;
        while (m != 0) {
            int x = m % 10;
            if (n % x == 0) {
                count++;
            }
            m = m / 10;
        }
        return count;
    }

    public static ArrayList<Integer> union(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        for (int value : set) {
            list.add(value);
        }
        return list;
    }

    public static boolean anagram(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

    public static boolean palindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static int kth_element_from_the_end(Node head, int k) {
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public static boolean power_of_2(int n) {
        return (n & n - 1) == 0;
    }

    public static ArrayList<Integer> common_in_three_sorted_array(int a1[], int a2[], int a3[], int n1, int n2,
            int n3) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (a1[i] == a2[j] && a1[i] == a3[k]) {
                if (list.get(list.size() - 1) != a1[i]) {
                    list.add(a1[i]);
                }
                i++;
                j++;
            } else if (a1[i] < a2[j]) {
                i++;
            } else if (a2[j] < a3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return list;
    }

    public static boolean pairsum(int arr[], int n, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(target - arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }
        return false;
    }

    public static boolean primeNumber(int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void reverse(char ch[], int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        i++;
        j--;
    }

    public static String reverseword(String str, int n) {
        char ch[] = str.toCharArray();
        reverse(ch, 0, n - 1);
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == '.') {
                reverse(ch, start, i - 1);
                start = i + 1;
            }
        }
        reverse(ch, start, n - 1);
        return ch.toString();
    }

    public static boolean check_array_equal(int arr1[], int arr2[], int n1, int n2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        for (int i = 0; i < n2; i++) {
            if (!map.containsKey(arr2[i]) || map.get(arr2[i]) == 0) {
                return false;
            }
            map.put(arr2[i], map.get(arr2[i]) - 1);
        }
        return true;
    }

    public static void move_zero_end(int arr[], int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[j++] = arr[i];
            }
        }
        while (j < n) {
            arr[j] = 0;
        }
    }

    public static int middle_of_linkedList(Node head) {
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static int[] frequency(int arr[], int n) {
        int freq[] = new int[n];
        for (int i = 0; i < n; i++) {
            freq[arr[i] - 1]++;
        }
        return freq;
    }

    public static ArrayList<Integer> dfsgraph(ArrayList<ArrayList<Integer>> graph, int v) {
        boolean visited[] = new boolean[v];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                dfs(graph, visited, list, i);
            }
        }
        return list;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], ArrayList<Integer> list, int node) {
        visited[node] = true;
        list.add(node);
        for (int neighbour : graph.get(node)) {
            if (visited[neighbour] == false) {
                dfs(graph, visited, list, neighbour);
            }
        }
    }

    public static int nth_fibonacci_number(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static Node reverse_the_list(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        Node forw = null;

        while (curr != null) {
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static class meeting {
        int start;
        int end;

        meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int nmeetinginroow(int start[], int end[]) {
        int n = start.length;
        ArrayList<meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new meeting(start[i], end[i]));
        }
        Collections.sort(list, (a, b) -> a.end - b.end);
        int count = 1;
        int last_time = list.get(0).end;

        for (int i = 1; i < n; i++) {
            if (list.get(i).start > last_time) {
                count++;
                last_time = list.get(i).end;
            }
        }
        return count;
    }

    public static int squareroot(int n) {
        int low = 1;
        int high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int square = mid * mid;

            if (square == n) {
                return mid;
            } else if (square < n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean balanced_tree(Node root) {
        return check(root) != -1;
    }

    public static int check(Node root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        if (left == -1)
            return -1;
        int right = check(root.right);
        if (right == -1)
            return -1;
        int diff = Math.abs(left - right);
        if (diff > 1)
            return -1;
        return 1 + Math.max(left, right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);
    }

    public static int remove_duplicate_from_sorted_array(int arr[], int n) {
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[j]) {
                arr[++j] = arr[i];
            }
        }
        return j++;
    }

    public static void bubble_sort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public static Node remove_duplicate_from_sorted_linkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head.next;
        Node prev = head;

        while (curr != null) {
            if (curr.data != prev.data) {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }

    public static char first_non_repeating_element_on_string(String str, int n) {
        int freq[] = new int[26];
        for (int i = 0; i < n; i++) {
            freq[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (freq[str.charAt(i) - 'a'] == 1) {
                return str.charAt(i);
            }
        }
        return '$';
    }

    public static int find_kth_rotation(int arr[], int n) {
        int low = 0;
        int high = n - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[high]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check_array_is_sorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static String longest_common_prefix(String arr[], int n) {
        String result = arr[0];
        for (int i = 1; i < n; i++) {
            result = compare(result, arr[i]);
            if (result.equals("")) {
                return "$";
            }
        }
        return result;
    }

    public static String compare(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int n1 = s1.length();
        int n2 = s2.length();

        for (int i = 0; i < Math.min(n1, n2); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            result.append(s1.charAt(i));
        }
        return result.toString();
    }

    public static int first_repeating_element_in_array(int arr[], int n) {
        int ans = -1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                ans = arr[i];
            }
            set.add(arr[i]);
        }
        return ans;
    }

    public static int[] product_of_array_except_itself(int arr[], int n) {
        int result[] = new int[n];
        result[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i + 1] * arr[i];
        }
        int mul = 1;
        for (int i = 0; i < n - 1; i++) {
            result[i] = mul * result[i + 1];
            mul *= arr[i];
        }
        result[n - 1] = mul;
        return result;
    }

    public static boolean identical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return identical(root1.left, root2.left) && identical(root1.right, root2.right);
    }

    public static boolean find_pair_with_given_differences(int arr[], int n, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i] + target) || set.contains(arr[i] - target)) {
                return true;
            }
        }
        return false;
    }

    public static int transition_point(int arr[], int n) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == 1) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int chocolate_distribution(int arr[], int n, int k) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - k; i++) {
            diff = Math.min(diff, arr[i + k - 1] - arr[i]);
        }
        return diff;
    }

    public static void insertionsort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[i - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }

    public static boolean stringrotatebytwoplace(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        boolean rotate1 = true;
        boolean rotate2 = true;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt((i + 2) % n)) {
                rotate1 = false;
            }
            if (s1.charAt(i) != s2.charAt((n + i - 2) % n)) {
                rotate2 = false;
            }
        }
        return rotate1 || rotate2;
    }

    public static String rotate(String str, int n, int k) {
        char ch[] = str.toCharArray();
        reverse(ch, 0, n - 1);
        reverse(ch, 0, k - 1);
        reverse(ch, k, n - 1);

        return ch.toString();
    }

    public static boolean kthbitisset(int n, int k) {
        int shift = n >> k;
        return (shift & 1) == 1;
    }

    public static Node remove_duplicate_from_unsorted_linkedList(Node head) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        Node curr = head;
        while (curr != null) {
            if (!set.contains(curr.data)) {
                temp.next = curr;
                temp = temp.next;
                set.add(curr.data);
            }
            curr = curr.next;
        }
        temp.next = null;
        return dummyNode.next;
    }

    public static int minimum_distance(int arr[], int n, int x, int y) {
        int diff = Integer.MAX_VALUE;
        int x_index = -1;
        int y_index = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                x_index = i;
            }
            if (arr[i] == y) {
                y_index = i;
            }
            if (x_index != -1 && y_index != -1) {
                diff = Math.min(diff, Math.abs(x - y));
            }
        }
        return diff;
    }

    public static void reversearray(int arr[], int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void mirrorTree(Node root) {
        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public static ArrayList<Integer> levelOrderTraversalspiralorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty() || !st2.isEmpty()) {

            while (!st1.isEmpty()) {
                Node temp = st1.pop();
                list.add(temp.data);
                if (temp.right != null) {
                    st2.push(temp.right);
                }
                if (temp.left != null) {
                    st2.push(temp.left);
                }
            }
            while (!st2.isEmpty()) {
                Node temp = st2.pop();
                list.add(temp.data);
                if (temp.left != null) {
                    st1.push(temp.left);
                }
                if (temp.right != null) {
                    st2.push(temp.right);
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> intersectionOftwoarray(int arr1[], int arr2[], int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < m; i++) {
            if (set.contains(arr2[i])) {
                list.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        return list;
    }

    public static ArrayList<Integer> alternativepostivenegative(int arr[], int n) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                negative.add(arr[i]);
            } else {
                positive.add(arr[i]);
            }
        }
        for (int i = 0; i < positive.size(); i++) {
            ans.add(positive.get(i));
            ans.add(negative.get(i));
        }
        return ans;
    }

    public static void selectionsort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static boolean perfectNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
            int pair = n / i;
            if (pair != i) {
                sum += pair;
            }
        }
        return sum == n;
    }

    public static int minimumbst(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static int maximumbst(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static int counttriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == arr[i]) {
                    count++;
                }
                if (sum < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static int sum1tondivisor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i * (n / i);
        }
        return sum;
    }

    public static int maximum_sum_subarray_of_size_k(int arr[], int n, int k) {
        int max_sum = 0;
        for (int i = 0; i < k; i++) {
            max_sum += arr[i];
        }
        for (int i = k; i < n; i++) {
            max_sum = Math.max(max_sum, max_sum - arr[i - k] + arr[i]);
        }
        return max_sum;
    }

    public static boolean isomorphicString(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 != n2) {
            return false;
        }

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < n1; i++) {

            char sch = s1.charAt(i);
            char tch = s2.charAt(i);

            if (map1.containsKey(sch)) {
                if (map1.get(sch) != tch) {
                    return false;
                }
            }
            map1.put(sch, tch);

            if (map2.containsKey(tch)) {
                if (map2.get(tch) != sch) {
                    return false;
                }
            }
            map2.put(tch, sch);
        }
        return true;
    }

    public static int first_elementof_koccurance(int arr[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) >= k) {
                return arr[i];
            }
        }
        return -1;
    }

    public static boolean armstrong_number(int n) {
        int m = n;
        int sum = 0;
        while (m != 0) {
            int x = m % 10;
            sum = x * x * x;
            m = m / 10;
        }
        return sum == n;
    }

    public static Node reverseDoublyLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            curr = curr.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    public static ArrayList<Integer> rightviewOf_binarytree(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;

        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                Node temp = q.remove();
                if (i == n - 1) {
                    list.add(temp.data);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        find_inorder(root, list);
        return list;
    }

    public static void find_inorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        find_inorder(root.left, list);
        list.add(root.data);
        find_inorder(root.right, list);
    }

    public static class Stack {
        int size = 0;
        Node head = null;

        boolean isEmpty() {
            return head == null;
        }

        void push(int key) {
            Node newNode = new Node(key);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        int pop() {
            if (head == null) {
                return -1;
            }
            int popedelement = head.data;
            head = head.next;
            return popedelement;
        }

        int peek() {
            if (head == null) {
                System.out.println("list is empty : ");
                return -1;
            }
            return head.data;
        }
    }

    public static boolean search(int matrix[][], int target) {
        int i = 0;
        int j = matrix[0].length;
        int n = matrix.length;

        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static ArrayList<Integer> ceil_floor(int arr[], int n, int target) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int ceil = -1;
        int floor = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > min && arr[i] <= target) {
                min = arr[i];
                floor = arr[i];
            }
            if (arr[i] < max && arr[i] >= target) {
                max = arr[i];
                ceil = arr[i];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(floor);
        list.add(ceil);
        return list;
    }

    public static int thirdlargest(int arr[], int n) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2 && arr[i] != max1) {
                max3 = max2;
                max2 = arr[i];
            } else if (arr[i] > max3 && arr[i] != max2 && arr[i] != max1) {
                max3 = arr[i];
            }
        }
        return max3;
    }

    public static void three_way_partiton(int arr[], int n, int a, int b) {
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (mid <= high) {
            if (arr[mid] < a) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if (arr[mid] > b) {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            } else {
                mid++;
            }
        }
    }

    public static ArrayList<Integer> node_without_sibling(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        find(root, list);
        return list;
    }

    public static void find(Node root, ArrayList<Integer> list) {
        if (root == null && root.right == null && root.left == null) {
            return;
        }
        if (root.left == null && root.right != null) {
            list.add(root.right.data);
        } else if (root.right == null && root.left != null) {
            list.add(root.left.data);
        }
        find(root.left, list);
        find(root.right, list);
    }

    public static boolean circular_linkedList(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next == head) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static int positionoffirstsetbit(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            if ((n & 1) == 1) {
                return count;
            }
            n = n >> 1;
        }
        return count;
    }

    public static Node insertinbst(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (root.data < key) {
            root.right = insertinbst(root.right, key);
        } else if (root.data > key) {
            root.left = insertinbst(root.left, key);
        }
        return root;
    }

    public static int kthlargest(Node root, int k) {
        int largest[] = new int[] { 0 };
        int count[] = new int[] { 0 };

        findlargest(root, largest, count, k);
        return largest[0];
    }

    public static void findlargest(Node root, int largest[], int count[], int k) {
        if (root == null || count[0] >= k) {
            return;
        }
        findlargest(root.right, largest, count, k);
        count[0]++;
        if (count[0] == k) {
            largest[0] = root.data;
            return;
        }
        findlargest(root.left, largest, count, k);
    }

    public static int kthsmallest(Node root, int k) {
        int smallest[] = new int[] { 0 };
        int count[] = new int[] { 0 };

        findsmallest(root, smallest, count, k);
        return smallest[0];
    }

    public static void findsmallest(Node root, int smallest[], int count[], int k) {
        if (root == null || count[0] >= k) {
            return;
        }
        findsmallest(root.left, smallest, count, k);
        count[0]++;
        if (count[0] == k) {
            smallest[0] = root.data;
            return;
        }
        findsmallest(root.right, smallest, count, k);
    }

    public static boolean symmetrictree(Node root) {
        return check_symmetric(root.left, root.right);
    }

    public static boolean check_symmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.data != root2.data)
            return false;
        return check_symmetric(root1.left, root2.right) && check_symmetric(root1.right, root2.left);
    }

    public static int countpairfromtwoarray(int arr1[], int arr2[], int n, int m, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            if (set.contains(target - arr2[i])) {
                count++;
            }
        }
        return count;
    }

    public static int indexofextraelement(int arr1[], int arr2[], int n, int m) {
        int low = 0;
        int high = m - 1;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr1[mid] == arr2[mid]) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void negativeelementatend(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                arr[j++] = arr[i];
            } else {
                list.add(arr[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            arr[j] = list.get(i);
            j++;
        }
    }

    public static void reversefirstkofqueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<Integer>();
        int n = q.size();
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }
        while (!st.isEmpty()) {
            q.add(st.pop());
        }
        for (int i = 0; i < n - k; i++) {
            q.add(q.remove());
        }
    }

    public static void deletemid(Stack<Integer> st) {
        int n = st.size();
        Stack<Integer> helper = new Stack<>();
        for (int i = 0; i < n / 2; i++) {
            helper.push(st.pop());
        }
        st.pop();
        while (!helper.isEmpty()) {
            st.push(helper.pop());
        }
    }

    public static int minimumelementinrotatesortedarray(int arr[], int n) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[high]) {

                high = mid - 1;
            } else {
             low = mid + 1;
            }
        }
        return arr[low];
    }
    public static int bitonicPoint(int arr[] , int n){
        int low = 0;
        int high = n - 1;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] < arr[mid + 1]){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void revesethequeue(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        int n = q.size();
        while(!q.isEmpty()){
            st.push(q.remove());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
    }
    public static int noOf1(int n){
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
    public static void zigzagarray(int arr[] , int n){
        for(int i = 1; i<n - 1; i+=2){
            if(arr[i] < arr[i - 1]){
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            if(arr[i] < arr[i + 1]){
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
    public static int smallestsubarraywithsumgreaterthanx(int arr[] , int n , int target){
        int sum = 0;
        int length = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            while(j < i && sum > target){
                length = Math.min(length , i - j + 1);
                sum -= arr[j];
                j++;
            }
        }
        return length;
    }
    public static Node deleteNodehavinggreatervalueonright(Node head){
        if(head == null || head.next == null){
            return head;
        }
        head = reverse_the_list(head);
        int max = head.data;
        Node curr = head;

        while(curr != null && curr.next != null){
            if(curr.next.data < max){
                curr.next = curr.next.next;
            }
            else{
                max = curr.next.data;
                curr = curr.next;
            }
        }
        head = reverse_the_list(head);
        return head;
    }
    public static int inorderpredecessor(Node root , int x){
        if(root == null){
            return -1;
        }
        int ans = 0;
        while(root != null){
            if(root.data < x){
                ans = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return ans;
    }
    public static int inordersuccessor(Node root , int x){
        if(root == null){
            return -1;
        }
        int ans = 0;
        while(root != null){
            if(root.data > x){
                ans = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ans;
    }
    public static Node intersectionoftwosortedlinkedList(Node head1 , Node head2){
         
        if((head1 == null && head2 == null) || (head1 == null || head2 == null)){
            return null;
        }
        Node temp1 = head1;
        Node temp2 = head2;

        Node dummyNode = new Node(-1);
        Node curr = dummyNode;

        while(temp1 != null && temp2 != null){

            if(temp1.data == temp2.data){
                curr.next = new Node(temp1.data);
                curr = curr.next;
            }
            else if(temp1.data < temp2.data){
                temp1 = temp1.next;
            }
            else{
                temp2 = temp2.next;
            }
        }
        curr.next = null;
        return dummyNode.next;
    }
    public static ArrayList<Integer> reveselevelordertraversal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
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
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
    public static ArrayList<ArrayList<Integer>>  levelordertraversal(Node root){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i<n; i++){
                Node node = q.remove();
                temp.add(node.data);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
    public static ArrayList<ArrayList<String>> groupAnagram(String arr[] , int n){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        HashMap<String , ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            String s = arr[i];
            int freq[] = new int[26];
            for(int j = 0; j<s.length(); j++){
                freq[s.charAt(i) - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for(int k = 0; k<26; k++){
                key.append(freq[k]).append('#');
            }
            if(!map.containsKey(key.toString())){
                ArrayList<String> temp = new ArrayList<>();
                map.put(key.toString() , temp);
            }
            map.get(key.toString()).add(s);
        }
        for(ArrayList<String> value : map.values()){
            list.add(value);
        }
        return list;
    }
    public static String removeduplicate(String str){
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
        return ans.toString();
    }
    public static Node removemiddleofLinkedList(Node head){
        if(head == null || head.next == null ){
            return null;
        }
        Node slow = head;
        Node fast  = head;
        Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
    public static ArrayList<Integer> postordertravesal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root , list);
        return list;
    }
    public static void postorder(Node root , ArrayList<Integer> list){
        if(root == null){
            return;
        }
        postorder(root.left , list);
        postorder(root.right , list);
        list.add(root.data);
    }
    public static int largest_bst(Node root){
        return solve(root).largest;
    }
    public static class info1{
        boolean isbst;
        int min;
        int max;
        int size;
        int largest;
        info1(boolean isbst , int min , int max , int size , int largest){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.size = size;
            this.largest = largest;
        }
    }
    public static info1 solve(Node root){
        if(root == null){
            return new info1(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0 , 0);
        }
        info1 left = solve(root.left);
        info1 right = solve(root.right);

        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int size = left.size + right.size + 1;
            int min = Math.min(root.data , left.min);
            int max = Math.max(root.data , right.max);
            int largest = Math.max(left.largest , right.largest);
            return new info1(true , min , max , size , largest);
        }
        int largest = Math.max(left.largest , right.largest);
        return new info1(false , 0 , 0 , 0 , largest);
    }
    public static int maximumsumbst(Node root){
        return solve2(root).maxsum;
    }
    public static class info2{
        boolean isbst;
        int min;
        int max;
        int sum;
        int maxsum;
        info2(boolean isbst , int min , int max , int sum , int maxsum){
            this.isbst = isbst;
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.maxsum = maxsum;
        }
    }
    public static info2 solve2(Node root){
        if(root == null){
            return new info2(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0 , 0);
        }
        info2 left = solve2(root.left);
        info2 right = solve2(root.right);
        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int sum = root.data + left.sum + right.sum;
            int min = Math.min(root.data , left.min);
            int max = Math.max(root.data , right.max);
            int maxsum = Math.max(left.maxsum , right.maxsum);
            return new info2(true , min , max , sum , maxsum);
        }
        int maxsum = Math.max(left.maxsum , right.maxsum);
        return new info2(false , 0 , 0 , 0 , maxsum);
    }
    public static int counttotalbst(Node root){
        return solve3(root).count;
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
    public static info3 solve3(Node root){
        if(root == null){
            return new info3(true , Integer.MAX_VALUE , Integer.MIN_VALUE , 0);
        }
        info3 left = solve3(root.left);
        info3 right = solve3(root.right);

        if(left.isbst && right.isbst && left.max < root.data && right.min > root.data){
            int count = left.count + right.count + 1;
            int min = Math.min(root.data , left.min);
            int max = Math.max(root.data , right.max);
            return new info3(true , min , max , count);
        }
        int count = left.count + right.count;
        return new info3(false , 0 , 0 , count);
    }
    public static ArrayList<Integer> mergetwobst(Node root1 , Node root2){
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
                    Node temp = st1.pop();
                    list.add(temp.data);
                    curr1 = temp.right;
                }
                else{
                    Node temp = st2.pop();
                    list.add(temp.data);
                    curr2 = temp.right;
                }
            }
            else if(!st1.isEmpty()){
                Node temp = st1.pop();
                list.add(temp.data);
                curr1 = temp.right;
            }
             else {
                Node temp = st2.pop();
                list.add(temp.data);
                curr2 = temp.right;
            }
        }
        return list;
    }
    public static int ceilinbst(Node root , int target){
        int ans = -1;
        while(root != null){
            if(root.data >= target){
                ans = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ans;
    }
    public static int floorinbst(Node root , int target){
        int ans = -1;
        while(root != null){
            if(root.data <= target){
                ans = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return ans;
    }
    public static boolean pairsum(Node root , int target){
        Stack<Node> st1 = new Stack<>();
        Stack<node> st2 = new Stack<>();
        Node curr1 = root;
        Node curr2 = root;

        while(curr1 != null || curr2 != null || !st1.isEmpty() || !st2.isEmpty()){
            while(curr1!= null){
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
            if(st1.peek() == st2.peek()){
                return false;
            }
            int sum = st1.peek().data + st2.peek().data;
            if(sum == target){
                return true;
            }
            else if(sum < target){
                curr1 = st1.pop().right;
            }
            else{
                curr2 = st2.pop().left;
            }
        }
        return false;
    }
    public static int countpair(Node root1 , Node root2 , int target){
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
                curr1 = st1.pop().right;
            }
            else{
                curr2 = st2.pop().left;
            }
        }
        return count;
    }
    public static ArrayList<Integer> commoninbst(Node root1 , Node root2){
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
    public static Node insertinsortedlist(Node head , int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null && temp.next.data <= data){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
    public static ArrayList<Integer> iterativeinorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        Stack<Node> st = new Stack<>();

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
    public static ArrayList<Integer> iterativepreorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            Node node = st.pop();
            list.add(node.data);
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return list;
    }
    public static ArrayList<Integer> iterativepostorderusingtwostack(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while(!st1.isEmpty()){
            Node node = st1.pop();
            st2.push(node);
            if(node.left != null){
                st1.push(node.left);
            }
            if(node.right != null){
                st1.push(node.right);
            }
        }
        while(!st2.isEmpty()){
            list.add(st2.pop());
        }
        return list;
    }
    public static ArrayList<Integer> iterativepostorderusing1stack(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        Node lastvisited = null;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            Node temp = st.peek();
            if(temp.right != null && temp.right != lastvisited){
                curr = temp.right;
            }
            else{
                lastvisited = temp;
                list.add(st.pop().data);
            }
        }
        return list;
    }
    public static ArrayList<Integer> morristraversal(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                list.add(curr.data);
                curr = curr.right;
            }
            else{
                Node pred = curr.right;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
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
    public static ArrayList<Integer> morrispreorder(Node root){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                list.add(curr.data);
                curr = curr.right;
            }
            else{
                Node pred = curr.right;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    list.add(curr.data);
                    pred.right = curr;
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
    public static Node swapkthNode(Node head , int k){
        if(head == null || head.next == null){
            return head;
        }
        int n = 0;
        Node temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        if(2 * k - 1 == n){
            return head;
        }
        Node x = head;
        Node prevx = null;

        Node y = head;
        Node prevy = null;

        for(int i = 1; i<k; i++){
            prevx = x;
            x = x.next;
        }
        for(int i = 1; i<n-k; i++){
            prevy = y;
            y = y.next;
        }

        if(prevx!= null){
            prevx.next = y;
        }
        if(prevy != null){
            prevy.next = x;
        }
        Node tempnext = x.next;
        x.next = y.next;
        y.next = tempnext;

        if(k == 0){
            head = x;
        }
        if(k == n){
            head = y;
        }
        return head;
    }
    public static Node constructbstfrompreorder(int preorder[] , int n){
        int index[] = new int[]{0};
        Node root = createbst_from_preorder(preorder , Integer.MIN_VALUE , Integer.MAX_VALUE , index);
        return root;
    }
    public static Node createbst_from_preorder(int preorder[] , int min , int max , int index[]){
        if(index[0] == preorder.length){
            return null;
        }
        int value = preorder[index[0]];
        if(value < min || value > max){
            return null;
        }
        Node root = new Node(value);
        index[0]++;

        root.left = createbst_from_preorder(preorder, min, root.data, index);
        root.right = createbst_from_preorder(preorder, root.data, max, index);
        return root;
    }
    public static Node constructbstfrompostorder(int postorder[] , int n){
        int index[] = new int[]{n - 1};
        Node root = createbst_from_postorder(postorder , Integer.MIN_VALUE , Integer.MAX_VALUE , index);
        return root;
    }
    public static Node createbst_from_postorder(int postorder[] , int min , int max , int index[]){
        if(index[0] < 0){
            return null;
        }
        int value = postorder[index[0]];
        if(value < min || value > max){
            return null;
        }
        Node root = new Node(value);
        index[0]--;

        root.right = createbst_from_postorder(postorder , root.data , max , index);
        root.left = createbst_from_postorder(postorder , min , root.data , index);
        return root;
    }
    public static boolean validpreorder(int preorder[] , int n){
        Stack<Integer> st = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(preorder[i] < min){
                return false;
            }
            while(!st.isEmpty() && preorder[i] > st.peek()){
                min = st.pop();
            }
            st.push(preorder[i]);
        }
        return true;
    }
    public static boolean validpostorder(int postorder[] , int n){
        Stack<Integer> st = new Stack<>();
        int max = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            if(postorder[i] > max){
                return false;
            }
            while(!st.isEmpty() && postorder[i] < st.peek()){
                max = st.pop();
            }
            st.push(postorder[i]);
        }
        return true;
    }

    
    public static void main(String[] args) {

    }
}

package solutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * 715. Range 模块
 * Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。
 *
 * addRange(int left, int right) 添加半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right)
 * 中尚未跟踪的任何数字到该区间中。
 * queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true。
 * removeRange(int left, int right) 停止跟踪区间 [left, right) 中当前正在跟踪的每个实数。
 *
 *
 * 示例：
 *
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true （区间 [10, 14) 中的每个数都正在被跟踪）
 * queryRange(13, 15): false （未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * queryRange(16, 17): true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 */
public class S0715a {
    class RangeModule {

        TreeMap<Integer,Integer> map;
        public RangeModule() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            while(true) {
                Map.Entry<Integer, Integer> entry = map.floorEntry(right); // key小于等于left的最大的那个键对应的entry
                if(entry!=null&&entry.getValue()>=left) {
                    right = Math.max(entry.getValue(), right);
                    left = Math.min(entry.getKey(), left);
                    map.remove(entry.getKey());
                } else {
                    break;
                }
            }
            map.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            return entry!=null&&entry.getValue()>=right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.lowerEntry(left); // key小于left的最大的那个键的entry
            if(entry!=null&&entry.getValue()>left) {
                map.put(entry.getKey(), left); // 直接把key对应的value给替换了，所以不需要remove
                if(entry.getValue()>right) {
                    map.put(right, entry.getValue());
                    return;
                }
            }
            // [left,right)的范围可能一下删了两个entry
            while(true) {
                entry = map.ceilingEntry(left); // key大于等于left的最小的那个键的entry
                if(entry!=null&&entry.getKey()<right) {
                    map.remove(entry.getKey());
                    if(entry.getValue()>right) {
                        map.put(right, entry.getValue());
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
}

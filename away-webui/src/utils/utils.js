// 取出key对应的value
export function getValue(dict, key) {
  let num = 0
  for (num in dict) {
    if (dict[num]["key"] == key) {
      return dict[num]["value"]
    }
  }
  return "未知状态"
}

// 对比两个对象，将右边对象中与左边对象属性相同的属性值赋给左边的对象的属性
export function setIntersectionObj(left_obj,right_obj){
  let key;
  let rk;
  let num;
  let intersection = [];
  for(key in left_obj){
    for( rk in right_obj){
      if (key == rk){
        intersection.push(key)
      }
    }
  }
  for(num in intersection) {
    key = intersection[num];
    left_obj[key] = right_obj[key];
  };
}

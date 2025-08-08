import request from '@/utils/request'

// 查询刀具库存列表
export function listLocalTool(query) {
  return request({
    url: '/storage/LocalTool/enlist',
    method: 'get',
    params: query
  })
}

// 查询刀具库存详细
export function getLocalTool(id) {
  return request({
    url: '/storage/LocalTool/' + id,
    method: 'get'
  })
}

// 新增刀具库存
export function addLocalTool(data) {
  return request({
    url: '/storage/LocalTool',
    method: 'post',
    data: data
  })
}

// 修改刀具库存
export function updateLocalTool(data) {
  return request({
    url: '/storage/LocalTool',
    method: 'put',
    data: data
  })
}

// 删除刀具库存
export function delLocalTool(id) {
  return request({
    url: '/storage/LocalTool/' + id,
    method: 'delete'
  })
}

//入库完成
export function addByNumber(lmlist){
  return request({
    url: '/storage/LocalTool/ByNumbner/add',
    data:lmlist,
    method: 'post',
    Headers:{
      "content-type":"application/json"
    }
  })
}
// 出库完成
export function reduceByNumber(lmlist){
  return request({
    url: '/storage/LocalTool/ByNumbner/reduce',
    data:lmlist,
    method: 'post',
    Headers:{
      "content-type":"application/json"
    }
  })
}

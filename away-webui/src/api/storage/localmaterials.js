import request from '@/utils/request'

// 查询本地材料实时库存列表
export function listLocalmaterials(query) {
  return request({
    url: '/storage/localmaterials/enlist',
    method: 'get',
    params: query
  })
}

// 查询本地材料实时库存详细
export function getLocalmaterials(id) {
  return request({
    url: '/storage/localmaterials/' + id,
    method: 'get'
  })
}

// 入库完成
export function addByNumber(lmlist){
  return request({
    url: '/storage/localmaterials/ByNumbner/add',
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
    url: '/storage/localmaterials/ByNumbner/reduce',
    data:lmlist,
    method: 'post',
    Headers:{
      "content-type":"application/json"
    }
  })
}

// 新增本地材料实时库存
export function addLocalmaterials(data) {
  return request({
    url: '/storage/localmaterials',
    method: 'post',
    data: data
  })
}

// 修改本地材料实时库存
export function updateLocalmaterials(data) {
  return request({
    url: '/storage/localmaterials',
    method: 'put',
    data: data
  })
}

// 删除本地材料实时库存
export function delLocalmaterials(id) {
  return request({
    url: '/storage/localmaterials/' + id,
    method: 'delete'
  })
}

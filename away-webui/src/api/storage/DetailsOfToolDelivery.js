import request from '@/utils/request'

// 查询刀具出库详细列表
export function listDetailsOfToolDelivery(query) {
  return request({
    url: '/storage/DetailsOfToolDelivery/list',
    method: 'get',
    params: query
  })
}

// 查询刀具出库详细详细
export function getDetailsOfToolDelivery(id) {
  return request({
    url: '/storage/DetailsOfToolDelivery/' + id,
    method: 'get'
  })
}

// 新增刀具出库详细
export function addDetailsOfToolDelivery(data) {
  return request({
    url: '/storage/DetailsOfToolDelivery',
    method: 'post',
    data: data
  })
}

// 修改刀具出库详细
export function updateDetailsOfToolDelivery(data) {
  return request({
    url: '/storage/DetailsOfToolDelivery',
    method: 'put',
    data: data
  })
}

// 删除刀具出库详细
export function delDetailsOfToolDelivery(id) {
  return request({
    url: '/storage/DetailsOfToolDelivery/' + id,
    method: 'delete'
  })
}

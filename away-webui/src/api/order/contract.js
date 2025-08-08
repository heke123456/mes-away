import request from '@/utils/request'

// 查询合同存储列表
export function listContract(query) {
  return request({
    url: '/order/contract/list',
    method: 'get',
    params: query
  })
}

// 查询合同存储详细
export function getContract(id) {
  return request({
    url: '/order/contract/' + id,
    method: 'get'
  })
}

// 新增合同存储
export function addContract(data) {
  return request({
    url: '/order/contract',
    method: 'post',
    data: data
  })
}

// 修改合同存储
export function updateContract(data) {
  return request({
    url: '/order/contract',
    method: 'put',
    data: data
  })
}

// 删除合同存储
export function delContract(id) {
  return request({
    url: '/order/contract/' + id,
    method: 'delete'
  })
}

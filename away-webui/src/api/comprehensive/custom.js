import request from '@/utils/request'

// 查询客户信息列表
export function listCustom(query) {
  return request({
    url: '/comprehensive/custom/enlist',
    method: 'get',
    params: query
  })
}

// 查询客户信息详细
export function getCustom(ID) {
  return request({
    url: '/comprehensive/custom/' + ID,
    method: 'get'
  })
}

// 新增客户信息
export function addCustom(data) {
  return request({
    url: '/comprehensive/custom',
    method: 'post',
    data: data
  })
}

// 修改客户信息
export function updateCustom(data) {
  return request({
    url: '/comprehensive/custom',
    method: 'put',
    data: data
  })
}

// 删除客户信息
export function delCustom(ID) {
  return request({
    url: '/comprehensive/custom/' + ID,
    method: 'delete'
  })
}

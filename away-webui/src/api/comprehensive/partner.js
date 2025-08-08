import request from '@/utils/request'

// 查询供货商信息列表
export function listCustom(query) {
  return request({
    url: '/comprehensive/partner/enlist',
    method: 'get',
    params: query
  })
}

// 查询供货商信息详细
export function getCustom(ID) {
  return request({
    url: '/comprehensive/partner/' + ID,
    method: 'get'
  })
}

// 新增供货商信息
export function addCustom(data) {
  return request({
    url: '/comprehensive/partner',
    method: 'post',
    data: data
  })
}

// 修改供货商信息
export function updateCustom(data) {
  return request({
    url: '/comprehensive/partner',
    method: 'put',
    data: data
  })
}

// 删除供货商信息
export function delCustom(ID) {
  return request({
    url: '/comprehensive/partner/' + ID,
    method: 'delete'
  })
}

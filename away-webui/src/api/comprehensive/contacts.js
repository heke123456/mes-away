import request from '@/utils/request'

// 查询联系人信息列表
export function listContacts(query) {
  return request({
    url: '/comprehensive/contacts/enlist',
    method: 'get',
    params: query
  })
}

// 查询联系人信息详细
export function getContacts(id) {
  return request({
    url: '/comprehensive/contacts/' + id,
    method: 'get'
  })
}

// 新增联系人信息
export function addContacts(data) {
  return request({
    url: '/comprehensive/contacts',
    method: 'post',
    data: data
  })
}

// 修改联系人信息
export function updateContacts(data) {
  return request({
    url: '/comprehensive/contacts',
    method: 'put',
    data: data
  })
}

// 删除联系人信息
export function delContacts(id) {
  return request({
    url: '/comprehensive/contacts/' + id,
    method: 'delete'
  })
}

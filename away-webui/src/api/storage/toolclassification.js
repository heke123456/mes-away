import request from '@/utils/request'

// 查询刀具分类列表
export function listToolclassification(query) {
  return request({
    url: '/toolclassification/toolclassification/list',
    method: 'get',
    params: query
  })
}

// 查询刀具分类详细
export function getToolclassification(id) {
  return request({
    url: '/toolclassification/toolclassification/' + id,
    method: 'get'
  })
}

// 新增刀具分类
export function addToolclassification(data) {
  return request({
    url: '/toolclassification/toolclassification',
    method: 'post',
    data: data
  })
}

// 修改刀具分类
export function updateToolclassification(data) {
  return request({
    url: '/toolclassification/toolclassification',
    method: 'put',
    data: data
  })
}

// 删除刀具分类
export function delToolclassification(id) {
  return request({
    url: '/toolclassification/toolclassification/' + id,
    method: 'delete'
  })
}

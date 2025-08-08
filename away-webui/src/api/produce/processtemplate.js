import request from '@/utils/request'

// 查询工序模板列表
export function listProcesstemplate(query) {
  return request({
    url: '/produce/processtemplate/list',
    method: 'get',
    params: query
  })
}

// 查询工序模板详细
export function getProcesstemplate(id) {
  return request({
    url: '/produce/processtemplate/' + id,
    method: 'get'
  })
}

// 新增工序模板
export function addProcesstemplate(data) {
  return request({
    url: '/produce/processtemplate',
    method: 'post',
    data: data
  })
}

// 修改工序模板
export function updateProcesstemplate(data) {
  return request({
    url: '/produce/processtemplate',
    method: 'put',
    data: data
  })
}

// 删除工序模板
export function delProcesstemplate(id) {
  return request({
    url: '/produce/processtemplate/' + id,
    method: 'delete'
  })
}

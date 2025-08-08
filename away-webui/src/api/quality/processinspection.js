import request from '@/utils/request'

// 查询过程检验列表
export function listProcessinspection(query) {
  return request({
    url: '/quality/processinspection/list',
    method: 'get',
    params: query
  })
}

// 查询过程检验详细
export function getProcessinspection(id) {
  return request({
    url: '/quality/processinspection/' + id,
    method: 'get'
  })
}

// 新增过程检验
export function addProcessinspection(data) {
  return request({
    url: '/quality/processinspection',
    method: 'post',
    data: data
  })
}

// 修改过程检验
export function updateProcessinspection(data) {
  return request({
    url: '/quality/processinspection',
    method: 'put',
    data: data
  })
}

// 删除过程检验
export function delProcessinspection(id) {
  return request({
    url: '/quality/processinspection/' + id,
    method: 'delete'
  })
}

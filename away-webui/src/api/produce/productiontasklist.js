import request from '@/utils/request'

// 查询生产任务单列表
export function listProductiontasklist(query) {
  return request({
    url: '/produce/productiontasklist/list',
    method: 'get',
    params: query
  })
}

// 查询生产任务单详细
export function getProductiontasklist(id) {
  return request({
    url: '/produce/productiontasklist/' + id,
    method: 'get'
  })
}

// 新增生产任务单
export function addProductiontasklist(data) {
  return request({
    url: '/produce/productiontasklist',
    method: 'post',
    data: data
  })
}

// 修改生产任务单
export function updateProductiontasklist(data) {
  return request({
    url: '/produce/productiontasklist',
    method: 'put',
    data: data
  })
}

// 删除生产任务单
export function delProductiontasklist(id) {
  return request({
    url: '/produce/productiontasklist/' + id,
    method: 'delete'
  })
}

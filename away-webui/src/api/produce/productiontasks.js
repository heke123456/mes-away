import request from '@/utils/request'

// 查询生产任务列表
export function listProductiontasks(query) {
  return request({
    url: '/produce/productiontasks/list',
    method: 'get',
    params: query
  })
}

// 查询生产任务详细
export function getProductiontasks(id) {
  return request({
    url: '/produce/productiontasks/' + id,
    method: 'get'
  })
}

// 新增生产任务
export function addProductiontasks(data) {
  return request({
    url: '/produce/productiontasks',
    method: 'post',
    data: data
  })
}

// 修改生产任务
export function updateProductiontasks(data) {
  return request({
    url: '/produce/productiontasks',
    method: 'put',
    data: data
  })
}

// 删除生产任务
export function delProductiontasks(id) {
  return request({
    url: '/produce/productiontasks/' + id,
    method: 'delete'
  })
}

// 删除任务清单任务
export function removeByProductionTasksFormIDs(productionTasksFormIDs){
  return request({
    url: '/produce/productiontasks/remove/'+productionTasksFormIDs,
    method: 'delete'
  })
}

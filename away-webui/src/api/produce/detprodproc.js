import request from '@/utils/request'

// 查询生产工艺工序详细列表
export function listDetprodproc(query) {
  return request({
    url: '/produce/detprodproc/list',
    method: 'get',
    params: query
  })
}

// 查询生产工艺工序详细详细
export function getDetprodproc(query) {
  return request({
    url: '/produce/detprodproc/get',
    method: 'get',
    params: query
  })
}

// 新增生产工艺工序详细
export function addDetprodproc(data) {
  return request({
    url: '/produce/detprodproc',
    method: 'post',
    data: data
  })
}

// 修改生产工艺工序详细
export function updateDetprodproc(data) {
  return request({
    url: '/produce/detprodproc',
    method: 'put',
    data: data
  })
}

// 删除生产工艺工序详细
export function delDetprodproc(productionTasksFormID) {
  return request({
    url: '/produce/detprodproc/' + productionTasksFormID,
    method: 'delete'
  })
}

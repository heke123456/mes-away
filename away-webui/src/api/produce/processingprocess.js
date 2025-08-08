import request from '@/utils/request'

// 查询加工工序信息列表
export function listProcessingprocess(query) {
  return request({
    url: '/produce/processingprocess/list',
    method: 'get',
    params: query
  })
}

// 查询加工工序信息详细
export function getProcessingprocess(id) {
  return request({
    url: '/produce/processingprocess/' + id,
    method: 'get'
  })
}

// 新增加工工序信息
export function addProcessingprocess(data) {
  return request({
    url: '/produce/processingprocess',
    method: 'post',
    data: data
  })
}

// 修改加工工序信息
export function updateProcessingprocess(data) {
  return request({
    url: '/produce/processingprocess',
    method: 'put',
    data: data
  })
}

// 删除加工工序信息
export function delProcessingprocess(id) {
  return request({
    url: '/produce/processingprocess/' + id,
    method: 'delete'
  })
}

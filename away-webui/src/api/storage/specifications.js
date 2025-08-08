import request from '@/utils/request'

// 查询规格类型列表
export function listSpecifications(query) {
  return request({
    url: '/storage/specifications/list',
    method: 'get',
    params: query
  })
}

// 查询规格类型详细
export function getSpecifications(id) {
  return request({
    url: '/storage/specifications/' + id,
    method: 'get'
  })
}

// 新增规格类型
export function addSpecifications(data) {
  return request({
    url: '/storage/specifications',
    method: 'post',
    data: data
  })
}

// 修改规格类型
export function updateSpecifications(data) {
  return request({
    url: '/storage/specifications',
    method: 'put',
    data: data
  })
}

// 删除规格类型
export function delSpecifications(id) {
  return request({
    url: '/storage/specifications/' + id,
    method: 'delete'
  })
}

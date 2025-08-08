import request from '@/utils/request'

// 查询材料信息详细单列表
export function listBasicinformationofmaterials(query) {
  return request({
    url: '/storage/basicinformationofmaterials/list',
    method: 'get',
    params: query
  })
}

// 查询材料信息详细单详细
export function getBasicinformationofmaterials(id) {
  return request({
    url: '/storage/basicinformationofmaterials/' + id,
    method: 'get'
  })
}

// 新增材料信息详细单
export function addBasicinformationofmaterials(data) {
  return request({
    url: '/storage/basicinformationofmaterials',
    method: 'post',
    data: data
  })
}

// 修改材料信息详细单
export function updateBasicinformationofmaterials(data) {
  return request({
    url: '/storage/basicinformationofmaterials',
    method: 'put',
    data: data
  })
}

// 删除材料信息详细单
export function delBasicinformationofmaterials(id) {
  return request({
    url: '/storage/basicinformationofmaterials/' + id,
    method: 'delete'
  })
}

import request from '@/utils/request'

// 查询需求材料列表
export function listMaterialListOfTechnology(query) {
  return request({
    url: '/produce/MaterialListOfTechnology/list',
    method: 'get',
    params: query
  })
}

// 查询需求材料详细
export function getMaterialListOfTechnology(id) {
  return request({
    url: '/produce/MaterialListOfTechnology/' + id,
    method: 'get'
  })
}

// 新增需求材料
export function addMaterialListOfTechnology(data) {
  return request({
    url: '/produce/MaterialListOfTechnology',
    method: 'post',
    data: data
  })
}

// 修改需求材料
export function updateMaterialListOfTechnology(data) {
  return request({
    url: '/produce/MaterialListOfTechnology',
    method: 'put',
    data: data
  })
}

// 删除需求材料
export function delMaterialListOfTechnology(id) {
  return request({
    url: '/produce/MaterialListOfTechnology/' + id,
    method: 'delete'
  })
}

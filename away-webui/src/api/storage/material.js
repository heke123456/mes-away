import request from '@/utils/request'

// 查询材料基本信息列表
export function listMaterial(query) {
  return request({
    url: '/storage/material/enlist',
    method: 'get',
    params: query
  })
}

// 查询材料基本信息详细
export function getMaterial(id) {
  return request({
    url: '/storage/material/' + id,
    method: 'get'
  })
}

// 新增材料基本信息
export function addMaterial(data) {
  return request({
    url: '/storage/material',
    method: 'post',
    data: data
  })
}

// 修改材料基本信息
export function updateMaterial(data) {
  return request({
    url: '/storage/material',
    method: 'put',
    data: data
  })
}

// 删除材料基本信息
export function delMaterial(id) {
  return request({
    url: '/storage/material/' + id,
    method: 'delete'
  })
}

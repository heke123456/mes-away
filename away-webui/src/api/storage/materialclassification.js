import request from '@/utils/request'

// 查询材料分类列表
export function listMaterialclassification(query) {
  return request({
    url: '/storage/materialclassification/list',
    method: 'get',
    params: query
  })
}

// 查询材料分类详细
export function getMaterialclassification(id) {
  return request({
    url: '/storage/materialclassification/' + id,
    method: 'get'
  })
}

// 新增材料分类
export function addMaterialclassification(data) {
  return request({
    url: '/storage/materialclassification',
    method: 'post',
    data: data
  })
}

// 修改材料分类
export function updateMaterialclassification(data) {
  return request({
    url: '/storage/materialclassification',
    method: 'put',
    data: data
  })
}

// 删除材料分类
export function delMaterialclassification(id) {
  return request({
    url: '/storage/materialclassification/' + id,
    method: 'delete'
  })
}

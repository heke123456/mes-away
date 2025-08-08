import request from '@/utils/request'

// 查询材料入库详细列表
export function listMatlwarehousingdet(query) {
  return request({
    url: '/storage/matlwarehousingdet/list',
    method: 'get',
    params: query
  })
}

// 查询材料入库详细详细
export function getMatlwarehousingdet(id) {
  return request({
    url: '/storage/matlwarehousingdet/' + id,
    method: 'get'
  })
}

// 新增材料入库详细
export function addMatlwarehousingdet(data) {
  return request({
    url: '/storage/matlwarehousingdet',
    method: 'post',
    data: data
  })
}

// 修改材料入库详细
export function updateMatlwarehousingdet(data) {
  return request({
    url: '/storage/matlwarehousingdet',
    method: 'put',
    data: data
  })
}

// 删除材料入库详细
export function delMatlwarehousingdet(id) {
  return request({
    url: '/storage/matlwarehousingdet/' + id,
    method: 'delete'
  })
}

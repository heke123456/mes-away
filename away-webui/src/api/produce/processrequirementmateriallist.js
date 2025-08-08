import request from '@/utils/request'

// 查询工艺需求材料列表
export function listProcessrequirementmateriallist(query) {
  return request({
    url: '/produce/processrequirementmateriallist/list',
    method: 'get',
    params: query
  })
}

// 查询工艺需求材料详细
export function getProcessrequirementmateriallist(id) {
  return request({
    url: '/produce/processrequirementmateriallist/' + id,
    method: 'get'
  })
}

// 新增工艺需求材料
export function addProcessrequirementmateriallist(data) {
  return request({
    url: '/produce/processrequirementmateriallist',
    method: 'post',
    data: data
  })
}

// 修改工艺需求材料
export function updateProcessrequirementmateriallist(data) {
  return request({
    url: '/produce/processrequirementmateriallist',
    method: 'put',
    data: data
  })
}

// 删除工艺需求材料
export function delProcessrequirementmateriallist(id) {
  return request({
    url: '/produce/processrequirementmateriallist/' + id,
    method: 'delete'
  })
}

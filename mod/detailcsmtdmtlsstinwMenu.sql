-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客供入库详细', '2191', '1', 'detailcsmtdmtlsstinw', 'storage/detailcsmtdmtlsstinw/index', 1, 0, 'C', '0', '0', 'storage:detailcsmtdmtlsstinw:list', '#', 'admin', sysdate(), '', null, '客供入库详细菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客供入库详细查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'storage:detailcsmtdmtlsstinw:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客供入库详细新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'storage:detailcsmtdmtlsstinw:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客供入库详细修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'storage:detailcsmtdmtlsstinw:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客供入库详细删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'storage:detailcsmtdmtlsstinw:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('客供入库详细导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'storage:detailcsmtdmtlsstinw:export',       '#', 'admin', sysdate(), '', null, '');
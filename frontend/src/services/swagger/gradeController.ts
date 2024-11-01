// @ts-ignore
/* eslint-disable */
import { request } from '@umijs/max';

/** 此处后端没有提供注释 GET /grades */
export async function getAllGrades(options?: { [key: string]: any }) {
  return request<API.ApiResponseListGrade>('/grades', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 POST /grades */
export async function createGrade(body: API.Grade, options?: { [key: string]: any }) {
  return request<API.ApiResponseGrade>('/grades', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 GET /grades/${param0} */
export async function getGradeById(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.getGradeByIdParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.ApiResponseGrade>(`/grades/${param0}`, {
    method: 'GET',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 PUT /grades/${param0} */
export async function updateGrade(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.updateGradeParams,
  body: API.Grade,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.ApiResponseGrade>(`/grades/${param0}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    params: { ...queryParams },
    data: body,
    ...(options || {}),
  });
}

/** 此处后端没有提供注释 DELETE /grades/${param0} */
export async function deleteGrade(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.deleteGradeParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.ApiResponseVoid>(`/grades/${param0}`, {
    method: 'DELETE',
    params: { ...queryParams },
    ...(options || {}),
  });
}

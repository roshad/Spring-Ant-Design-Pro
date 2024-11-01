declare namespace API {
  type ApiResponseCourse = {
    success?: boolean;
    data?: Course;
  };

  type ApiResponseGrade = {
    success?: boolean;
    data?: Grade;
  };

  type ApiResponseListCourse = {
    success?: boolean;
    data?: Course[];
  };

  type ApiResponseListGrade = {
    success?: boolean;
    data?: Grade[];
  };

  type ApiResponseListStudent = {
    success?: boolean;
    data?: Student[];
  };

  type ApiResponseStudent = {
    success?: boolean;
    data?: Student;
  };

  type ApiResponseVoid = {
    success?: boolean;
    data?: Record<string, any>;
  };

  type AuthRequest = {
    username?: string;
    password?: string;
    userId?: string;
  };

  type Class = {
    classId?: number;
    className?: string;
  };

  type Client = {
    cid?: number;
    image?: string;
    cname?: string;
    password?: string;
    phoneNumber?: string;
    email?: string;
    createTime?: string;
    ckind?: number;
    test?: number;
  };

  type Course = {
    courseId?: number;
    courseName?: string;
  };

  type deleteClassParams = {
    id: number;
  };

  type deleteClientParams = {
    id: number;
  };

  type deleteCourseParams = {
    id: number;
  };

  type deleteGradeParams = {
    id: number;
  };

  type deleteStudentParams = {
    id: number;
  };

  type getClassByIdParams = {
    id: number;
  };

  type getClientParams = {
    id: number;
  };

  type getCourseByIdParams = {
    id: number;
  };

  type getGradeByIdParams = {
    id: number;
  };

  type getStudentByIdParams = {
    id: number;
  };

  type getUserParams = {
    token: string;
  };

  type Grade = {
    gradeId?: number;
    studentId?: number;
    courseId?: number;
    score?: number;
  };

  type helloParams = {
    name?: string;
  };

  type Student = {
    studentId?: number;
    name?: string;
    gender?: string;
    classId?: number;
  };

  type updateClassParams = {
    id: number;
  };

  type updateClientParams = {
    id: number;
  };

  type updateCourseParams = {
    id: number;
  };

  type updateGradeParams = {
    id: number;
  };

  type updateStudentParams = {
    id: number;
  };
}

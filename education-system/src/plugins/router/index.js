import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../../views/auth/LoginView.vue'
import ProfileView from '../../views/profile/ProfileView.vue'
import OnboardingView from '../../views/onboarding/OnboardingView.vue'
import StudentRegisterView from '../../views/student/StudentRegisterView.vue'
import TeacherRegisterView from '../../views/teacher/TeacherRegisterView.vue'
import SubjectRegisterView from '../../views/subject/SubjectRegisterView.vue'
import ClassView from '../../views/class/ClassView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/profile',
      name: 'profile',
      component: ProfileView
    },
    {
      alias: '/',
      path: '/onboarding',
      name: 'onboarding',
      component: OnboardingView
    },
    {
      path: '/student-register',
      name: 'student-register',
      component: StudentRegisterView
    },
    {
      path: '/teacher-register',
      name: 'teacher-register',
      component: TeacherRegisterView
    },
    {
      path: '/subject-register',
      name: 'subject-register',
      component: SubjectRegisterView
    },
    {
      path: '/classroom',
      name: 'classroom',
      component: ClassView
    }
  ]
})
// TODO middleware
export default router

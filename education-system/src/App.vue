<script setup>
import {useRoute, useRouter} from "vue-router";
import {computed, onMounted} from "vue";
import {useCookies} from "vue3-cookies";

const route = useRoute();
const router = useRouter();
const {cookies} = useCookies();

const isLogin = computed(() => {
  return route.path === '/login';
})

const items = [
  { title: 'Profile', to: '/profile' },
  { title: 'Logout', to: '/login' }
];

const action = (item) => {
  if (item.to === '/login') {
    cookies.remove('Authorization')
  }
  router.push(item.to).catch(() => {});
}

onMounted(() => {
  if (!cookies.isKey('Authorization')) {
    router.push('/login').catch(() => {});
  }
})

</script>

<template>
  <v-app id="inspire">
    <v-app-bar
      v-if="!isLogin"
      elevation="1"
    >
      <v-container
        class="mx-auto d-flex align-center justify-start"
      >
        <v-btn
          variant="tonal"
          color="primary"
          class="mr-2"
          @click="router.push('/')"
        >
          Onboarding
        </v-btn>
        <v-btn
            variant="tonal"
            class="mr-2"
            @click="router.push('/classroom')"
        >
          ClassRoom
        </v-btn>
        <v-spacer/>
        <v-btn
          id="menu-activator"
          color="primary"
          variant="outlined"
        >
          Account
        </v-btn>
        <v-menu
          activator="#menu-activator"
          location="bottom"
        >
          <v-list class="elevation-0">
            <v-list-item
              v-for="(item, index) in items"
              :key="index"
              :value="index"
              class="pa-4"
              @click="action(item)"
            >
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-container>
    </v-app-bar>
    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

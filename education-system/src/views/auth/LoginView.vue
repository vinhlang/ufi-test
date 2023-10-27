<script setup>
import {reactive} from "vue";
import {useRouter} from "vue-router";
import authApi from "../../api/authApi";
import { useCookies } from "vue3-cookies";

const router = useRouter();
const { cookies } = useCookies();

const request = reactive({
  username: 'admin',
  password: 'admin'
});

const submit = async () => {
  let response = await authApi.login(request)
  cookies.set('Authorization', `${response['tokenType']} ${response['accessToken']}`)
  router.push('/').catch(() => {})
}

</script>

<template>
  <v-container class="fill-height d-flex align-center justify-center">
    <v-form class="h-50">
      <v-card
        elevation="0"
        class="pa-8" style="border: 1px solid #00478B"
      >
        <h1 class="text-primary">
          Education System
        </h1>
        <v-card-item class="py-4 px-0">
          <v-text-field
            v-model="request.username"
            variant="outlined"
            density="compact"
            hide-details="auto"
            placeholder="username"
            class="pb-4"
          />
          <v-text-field
            v-model="request.password"
            variant="outlined"
            density="compact"
            hide-details="auto"
            placeholder="password"
          />
        </v-card-item>
        <v-card-actions class="px-0">
          <v-btn
            block
            variant="flat"
            color="primary"
            @click="submit"
          >
            Login
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-form>
  </v-container>
</template>

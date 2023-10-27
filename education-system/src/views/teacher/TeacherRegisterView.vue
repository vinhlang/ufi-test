<script setup>
import {reactive} from "vue";
import VueDatePicker from '@vuepic/vue-datepicker';
import {useRouter} from "vue-router";
import teacherApi from "../../api/teacherApi";

const router = useRouter();

const request = reactive({
  firstName: null,
  lastName: null,
  address: null,
  email: null,
  birthday: null,
  sex: 1,
  active: 1
})

const submit = async () => {
  await teacherApi.save([{...request}])
  await router.push('/onboarding');
}

const cancel = () => {
  router.push('/onboarding');
}

</script>


<template>
  <v-container>
    <h1 class="text-center">Teacher Register</h1>
    <v-col
      cols="12"
      lg="7"
      class="mx-auto"
    >
      <v-row justify="center">
        <v-col
          cols="12"
          md="2"
          class="d-flex align-center"
        >
          <span>First Name</span>
        </v-col>
        <v-col
          cols="12"
          md="6"
        >
          <v-text-field
            v-model="request.firstName"
            variant="outlined"
            density="compact"
            hide-details="auto"
            placeholder="First Name"
          />
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col
          cols="12"
          md="2"
          class="d-flex align-center"
        >
          <span>Last Name</span>
        </v-col>
        <v-col
          cols="12"
          md="6"
        >
          <v-text-field
            v-model="request.lastName"
            variant="outlined"
            density="compact"
            hide-details="auto"
            placeholder="Last Name"
          />
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col
          cols="12"
          md="2"
          class="d-flex align-center"
        >
          <span>Birthday</span>
        </v-col>
        <v-col
          cols="12"
          md="6"
        >
          <vue-date-picker
            v-model="request.birthday"
            format="dd-MM-yyyy"
          />
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col
          cols="12"
          md="2"
          class="d-flex align-center"
        >
          <span>Address</span>
        </v-col>
        <v-col
          cols="12"
          md="6"
        >
          <v-text-field
            v-model="request.address"
            variant="outlined"
            density="compact"
            hide-details="auto"
            placeholder="Address"
          />
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col
          cols="12"
          md="2"
          class="d-flex align-center"
        >
          <span>Email</span>
        </v-col>
        <v-col
          cols="12"
          md="6"
        >
          <v-text-field
            v-model="request.email"
            variant="outlined"
            density="compact"
            hide-details="auto"
            placeholder="Email"
          />
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col
          cols="12"
          md="2"
          class="d-flex align-center"
        >
          <span>Sex</span>
        </v-col>
        <v-col
          cols="12"
          md="6"
          class="px-0"
        >
          <v-radio-group
            inline
            color="primary"
            hide-details="auto"
            v-model="request.sex"
          >
            <v-radio
              label="Male"
              :value="1"
            />
            <v-radio
              label="Female"
              :value="2"
            />
          </v-radio-group>
        </v-col>
      </v-row>
      <v-row justify="center">
        <v-col
          cols="12"
          md="8"
        >
          <div class="d-flex align-center justify-center">
            <v-btn
              variant="tonal"
              @click="cancel"
            >
              Back
            </v-btn>
            <v-spacer></v-spacer>
            <v-btn
              variant="tonal"
              color="primary"
              @click="submit"
            >
              Submit
            </v-btn>
          </div>
        </v-col>
      </v-row>
    </v-col>
  </v-container>
</template>

<style scoped>

</style>
<script setup>
import {onMounted, ref} from "vue";
import classApi from "../../api/classApi";
import ClassRegister from "./ClassRegister";

const classList = ref(null)
const showClassRegister = ref(false)

onMounted( async () => {
  classList.value = await classApi.getList();
})

const classRoomRegister = async (request) => {
  await classApi.save(request)
  classList.value = await classApi.getList()
}
</script>

<template>
  <v-container>
    <v-row style="gap: 8px">
      <v-btn
          color="primary"
          variant="tonal"
          append-icon="mdi-plus-circle"
          @click="showClassRegister = true"
      >
        Add Class
      </v-btn>
    </v-row>
    <v-row>
      <v-col
          class="mt-2"
          cols="12"
      >
        <strong>Class</strong>
      </v-col>
      <template
          v-for="(classroom, index) in classList"
          :key="index"
      >
        <v-col
            cols="6"
            md="3"
        >
          <v-sheet
              height="150"
              class="bg-grey pa-4 rounded"
          >
            <p>Name: {{ classroom['name'] }}</p>
            <p>Teacher: {{ classroom['firstNameTeacher'] }} {{ classroom['lastNameTeacher'] }}</p>
          </v-sheet>
        </v-col>
      </template>
    </v-row>
  </v-container>
  <class-register
    v-model="showClassRegister"
    @submit="classRoomRegister"
  />
</template>

<script setup>
import {onMounted, ref} from "vue";
import studentApi from "../../api/studentApi";
import teacherApi from "../../api/teacherApi";
import subjectApi from "../../api/subjectApi";

const students = ref(null)
const teachers = ref(null)
const subjects = ref(null)

onMounted( () => {
  Promise.all([
    studentApi.getList(),
    teacherApi.getList(),
    subjectApi.getList()
  ]).then((responseList) => {
    students.value = responseList[0]
    teachers.value = responseList[1]
    subjects.value = responseList[2]
  })
})
</script>

<template>
  <v-container>
    <v-row style="gap: 8px">
      <v-btn
        color="indigo"
        variant="tonal"
        append-icon="mdi-plus-circle"
        @click="$router.push('/teacher-register')"
      >
        Add Teacher
      </v-btn>
      <v-btn
        color="indigo"
        variant="tonal"
        append-icon="mdi-plus-circle"
        @click="$router.push('/student-register')"
      >
        Add Student
      </v-btn>
      <v-btn
        disabled
        color="indigo"
        variant="tonal"
        append-icon="mdi-plus-circle"
        @click="$router.push('/subject-register')"
      >
        Add Subject
      </v-btn>
    </v-row>
    <v-row>
      <v-col
        class="mt-2"
        cols="12"
      >
        <strong>Teacher</strong>
      </v-col>
      <template
        v-for="(teacher, index) in teachers"
        :key="index"
      >
        <v-col
          cols="6"
          md="2"
        >
          <v-sheet
            height="150"
            class="bg-grey pa-4 rounded"
          >
            <p>Name: {{ teacher['firstName'] }} {{ teacher['lastName'] }}</p>
            <p>Address: {{ teacher['address'] }}</p>
          </v-sheet>
        </v-col>
      </template>
    </v-row>
    <v-row>
      <v-col
        class="mt-2"
        cols="12"
      >
        <strong>Student</strong>
      </v-col>
      <template
        v-for="(student, index) in students"
        :key="index"
      >
        <v-col
          cols="6"
          md="2"
        >
          <v-sheet
            height="150"
            class="bg-grey pa-4 rounded"
          >
            <p>Name: {{ student['firstName'] }} {{ student['lastName'] }}</p>
            <p>Address: {{ student['address'] }}</p>
          </v-sheet>
        </v-col>
      </template>
    </v-row>
    <v-row>
      <v-col
          class="mt-2"
          cols="12"
      >
        <strong>Subject</strong>
      </v-col>
      <template
          v-for="(subject, index) in subjects"
          :key="index"
      >
        <v-col
            cols="6"
            md="2"
        >
          <v-sheet
              height="150"
              class="bg-grey pa-4 rounded"
          >
            <p>Name: {{ subject['name'] }} </p>
          </v-sheet>
        </v-col>
      </template>
    </v-row>
  </v-container>
</template>

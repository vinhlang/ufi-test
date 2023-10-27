<script setup>
import {onMounted, reactive, ref} from "vue";
import subjectApi from "../../api/subjectApi";
import teacherApi from "../../api/teacherApi";

defineProps({
  showClassRegister: Boolean
})
const emits = defineEmits([
  'submit'
])

const subjects = ref(null)
const teachers = ref(null)

const request = reactive({
  name: null,
  idSubject: null,
  idTeacher: null
})

onMounted(() => {
  Promise.all([
    subjectApi.getList(),
    teacherApi.getList(),
  ]).then((responseList) => {
    subjects.value = responseList[0]
    teachers.value = responseList[1]
  })
})

const submit = () => {
  emits('submit', {...request})
  emits('update:modelValue', false)
}
</script>

<template>
  <v-dialog
    :model-value="showClassRegister"
    persistent
    width="600"
    @update:modelValue="showClassRegister"
  >
    <v-card>
      <v-card-title
        class="bg-primary"
      >
        <span class="text-h5">Classroom Register</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-form>
            <v-row>
              <v-col
                cols="3"
                class="d-flex align-center"
              >
                <p>Name</p>
              </v-col>
              <v-col
                cols="9"
              >
                <v-text-field
                  v-model="request.name"
                  variant="outlined"
                  hide-details="auto"
                  density="compact"
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col
                cols="3"
                class="d-flex align-center"
              >
                <p>Subject</p>
              </v-col>
              <v-col
                cols="9"
              >
                <v-autocomplete
                  v-model="request.idSubject"
                  :items="subjects"
                  item-title="name"
                  item-value="id"
                  variant="outlined"
                  hide-details="auto"
                  density="compact"
                />
              </v-col>
            </v-row>
            <v-row>
              <v-col
                cols="3"
                class="d-flex align-center"
              >
                <p>Teacher</p>
              </v-col>
              <v-col
                cols="9"
              >
                <v-autocomplete
                  v-model="request.idTeacher"
                  :items="teachers"
                  item-title="lastName"
                  item-value="id"
                  variant="outlined"
                  hide-details="auto"
                  density="compact"
                />
              </v-col>
            </v-row>
          </v-form>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer/>
        <v-btn
          variant="tonal"
          @click="$emit('update:modelValue', false)"
        >
          Cancel
        </v-btn>
        <v-btn
          color="primary"
          variant="tonal"
          @click="submit"
        >
          Save
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<style scoped>

</style>

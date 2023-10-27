import './assets/main.css'
import './styles/overrides.sass'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './plugins/router'
import vuetify from './plugins/vuetify'
import VueCookies from 'vue3-cookies'
import '@vuepic/vue-datepicker/dist/main.css'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(vuetify)
app.use(VueCookies, {expireTimes: '7d'})

app.mount('#app')

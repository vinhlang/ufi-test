/**
 * plugins/vuetify.js
 *
 * Framework documentation: https://vuetifyjs.com`
 */

// Styles
import '@mdi/font/css/materialdesignicons.css'
import 'vuetify/styles'
import * as components from 'vuetify/components'
import * as labsComponents from 'vuetify/labs/components'

// Composables
import { createVuetify } from 'vuetify'

// https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
export default createVuetify({
  components: {
    ...components,
    ...labsComponents
  },
  theme: {
    themes: {
      light: {
        colors: {
          primary: '#00478B',
          secondary: '#5CBBF6',
        },
      },
    },
  },
})

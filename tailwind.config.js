/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/webapp/*.jsp",
    "./src/main/webapp/*.html",
  ],
  theme: {
    extend: {
      fontFamily: {
        'sans': ['Poppins', 'ui-sans-serif', 'system-ui'],
        'poppins': ['Poppins', 'sans-serif'],
      },
    },
  },
  plugins: [],
}

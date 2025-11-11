/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/webapp/*.jsp",
    "./src/main/webapp/*.html",
  ],
  theme: {
    extend: {
      colors: {
        'crypto-dark': '#0f0f1e',
        'crypto-card': '#1a1a2e',
        'crypto-blue': '#00d4ff',
        'crypto-purple': '#7b2ff7',
        'crypto-green': '#00ff88',
      },
      fontFamily: {
        'crypto': ['Inter', 'sans-serif'],
      },
    },
  },
  plugins: [],
}

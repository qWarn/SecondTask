const path = require('path');

module.exports = {
  entry: {
    app: './js/studentsList.js',
  },
  output: {
    path: path.resolve(__dirname, 'dist'),
    clean: true,
    filename: './js/studentsList.js',
  },
};

// server.js
const express = require('express');
const bodyParser = require('body-parser');
const nodemailer = require('nodemailer');
const app = express();
const port = 3000;

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.post('/register', async (req, res) => {
    const { email, username, password } = req.body;

    if (!email || !username || !password) {
        return res.status(400).send('Todos los campos son obligatorios');
    }

    try {
        await sendConfirmationEmail(email);
        res.status(200).send('Registro exitoso, correo de confirmación enviado.');
    } catch (error) {
        console.error('Error enviando correo:', error);
        res.status(500).send('Error enviando correo');
    }
});

const sendConfirmationEmail = async (email) => {
    let transporter = nodemailer.createTransport({
        service: 'gmail',
        auth: {
            user: 'your-email@gmail.com',
            pass: 'your-email-password'
        }
    });

    let mailOptions = {
        from: 'your-email@gmail.com',
        to: email,
        subject: 'Confirmación de registro',
        text: 'Gracias por registrarte. Por favor, confirma tu correo electrónico haciendo clic en el siguiente enlace: [enlace de confirmación]'
    };

    await transporter.sendMail(mailOptions);
};

app.listen(port, () => {
    console.log(`Servidor ejecutándose en http://localhost:${port}`);


    require('dotenv').config();

    let transporter = nodemailer.createTransport({
        service: 'gmail',
        auth: {
            user: process.env.EMAIL_USER,
            pass: process.env.EMAIL_PASS
        }
    });



});

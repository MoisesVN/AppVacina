import React, { useState,useEffect } from "react";
import { View, TextInput, Text, TouchableOpacity, Alert } from "react-native";
import styles from "./style.js";
import { useNavigation } from "@react-navigation/native";
import blogFetch from "../../axios/config.js"
import logo from "../imagens/logo.png"

export default function Form() {
    const navigation = useNavigation();
    const [email, setEmail] = useState("")
    const [senha, setSenha] = useState("")
    const [textButton] = useState("Entrar")
    let valoresGlobais = {};
    const id = 1;  
    function Entrar() {
        if (email == "" || senha == "") {
            createAlert();
        } else {
            getConta();
            //console.log(email , senha);//usei para verificar as informacoes recebidas do app no terminal
        }
    }

    //buscando na api e salvando em variaveis globais o email e a senha.
    async function getConta() {
        try {  
            const id = 1;      
            const response = await blogFetch.get(`/conta/${id}`);
            const data = response.data;
            //console.log(data);//usei para verificar as informacoes recebidas da api no terminal
            valoresGlobais = { 
                email : data.email,
                senha : data.senha
            };   
            logar();
        } catch (error) {
            console.log(error);//provalvemente email nao encontrado
            loginErrado();
        }
    }

    function logar(){
        if(email == valoresGlobais.email && senha == valoresGlobais.senha){
            navigation.navigate("Home");
        }else{
            loginErrado();
        }
    }
    
    const createAlert = () => Alert.alert(
        "Oops!",
        "Verifique se o campo email e senha estão preenchidos."
    );

    const loginErrado = () => Alert.alert(
        "Oops!",
        "Email ou senha errado"
    );
    
    return (
        <View style={styles.form}>
            <Text style={styles.Login}>Faça Login</Text>
            <View style={styles.Tela}>
                <Text style={styles.title}>Digite seu Email</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setEmail}
                    value={email}
                    placeholder="Email"
                    //keyboardType="numeric"
                />
                <Text style={styles.title}>Digite sua Senha</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setSenha}
                    value={senha}
                    placeholder="Senha"
                />
                <TouchableOpacity style={styles.buttonAcessar} onPress={() => navigation.navigate("RecuperarConta")}>
                    <Text style={styles.textButtonAcessar}>Esqueci minha senha</Text>
                </TouchableOpacity>
                <View style={styles.botaoArea}>
                    <TouchableOpacity style={styles.botao} onPress={() => navigation.navigate("Cadastro")}>
                        <Text style={styles.botaoS}>Cadastrar</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={[styles.botao, styles.botaoSalvar]}
                        onPress={() => Entrar()}
                    >
                        <Text style={styles.textButtonClean}>{textButton}</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>
    )
}

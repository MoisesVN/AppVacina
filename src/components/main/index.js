import React, { useState } from "react";
import { View, TextInput, Text, TouchableOpacity, Alert } from "react-native";
import  styles  from "./style.js";
import { useNavigation } from "@react-navigation/native";

export default function Form() {
    const navigation = useNavigation();

    const [matricula, setMatricula] = useState(null)
    const [senha, setSenha] = useState(null)
    const [textButton] = useState("Entrar")

    const createAlert = () => Alert.alert(
        "Oops!",
        "Verifique se o campo matrícula e senha estão preenchidos."
    );

    function Entrar() {
        if (matricula == null) {
            createAlert();
        }else{ if (senha == null){
          createAlert();
      }else{
        navigation.navigate("Home");
    }
        }
    }
    return (
            <View style={styles.form}>
            <Text style={styles.Login}>Faça Login</Text>
            <View style={styles.Tela}>
                <Text style={styles.title}>Digite seu CPF</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setMatricula}
                    value={matricula}
                    placeholder="CPF"
                    keyboardType="numeric"
                />
                <Text style={styles.title}>Digite sua Senha</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setSenha}
                    value={senha}
                    placeholder="Senha"
                />
                <TouchableOpacity style={styles.buttonAcessar}onPress={() => navigation.navigate("RecuperarConta")}>
                        <Text style={styles.textButtonAcessar}>Esqueci minha senha</Text>
                </TouchableOpacity>
                <View style={styles.botaoArea}>
                <TouchableOpacity style={styles.botao}  onPress={() => navigation.navigate("Cadastro")}>
                        <Text style={styles.botaoS}>Cadastrar</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={[styles.botao,styles.botaoSalvar]}
                    onPress={() => Entrar()}
                >
                    <Text style={styles.textButtonClean}>{textButton}</Text>
                    </TouchableOpacity>
                </View>
                </View>
            </View>
    )
}

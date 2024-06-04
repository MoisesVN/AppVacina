import React, { useState, useContext } from "react";
import { View, Text, TouchableOpacity, TextInput, Image, ScrollView, Alert } from "react-native";
import blogFetch from "../../axios/config";
import { useNavigation } from "@react-navigation/native";

import styles from './style';
import { AuthContext } from "../../context/auth";




export default function Cadastro() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");
    const { idToken } = useContext(AuthContext);
    const [nome, setNome] = useState ("");
    const [cpf, setCpf] = useState ("");
    const [dataNasc, setDataNasc] = useState ("");
    const [docSUS, setDocSUS] = useState ("");

    const patternData = () => Alert.alert(
        "Oops!",
        "Por favor, insira a data no formato YYYY-MM-DD"
    );

    const createAlert = () => Alert.alert(
        "Oops!",
        "Verifique se todos os campos estão preenchidos."
    );

    function cadastrar(){
        if (nome == "" || cpf == "" || dataNasc == "" || docSUS == ""){
            createAlert();
        } else {    
            postCadastro();
        }
    }

    async function postCadastro() {
         // Verifica se a data está em um formato aceitável (por exemplo, YYYY-MM-DD)
        const datePattern = /^\d{4}-\d{2}-\d{2}$/;
        if (!datePattern.test(dataNasc)) {
            patternData();
        } else {
            try {
                const idConta = idToken;
                const post = {  nome, cpf, dataNasc, docSUS, idConta };
                await blogFetch.post("/cadastros/cadastrar", post);
                navigation.navigate("Home");         
            } catch (error) {
                console.log(error);//pode apagar
            }
        }
    }

    return (

        <View style={styles.bodydiv}> 
        
            <ScrollView >
                <View>                  

                    <View style={styles.topo}>
                        
                        <Text style={styles.textTitle}>Cadastro de carteiras</Text>
                    </View>

                    <Text style={styles.txt}> Digite seu Nome:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setNome}
                        value={nome}
                        placeholder="Nome"
                    />

                    <Text style={styles.txt}> Digite seu CPF:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setCpf}
                        value={cpf}
                        placeholder="CPF"
                        keyboardType="numeric" 
                    />

                    <Text style={styles.txt}> Digite sua data de Nacimento:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setDataNasc}
                        value={dataNasc}
                        placeholder="data de Nacimento."
                        keyboardType="numeric" 
                    />

                    <Text style={styles.txt}> Digite seu Numero SUS:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setDocSUS}
                        value={docSUS}
                        placeholder="SUS" 
                        keyboardType="numeric"
                    />

                    <View style={styles.div}>

                        <TouchableOpacity
                            style={styles.buttonAcessar1}
                            onPress={() => cadastrar()}
                        >
                            <Text style={styles.textButtonAcessar}>Confimar</Text>
                        </TouchableOpacity>

                      
                    </View>
                </View>
            </ScrollView>
        </View>

    )


}


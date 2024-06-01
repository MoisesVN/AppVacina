import React, { useState } from "react";
import { View, Text, TouchableOpacity, TextInput, Image, ScrollView } from "react-native";
import blogFetch from "../../axios/config";
import { useNavigation } from "@react-navigation/native";

import styles from './style';

//import logo from '../../../assets/logo.png';
//nao estava conseguindo comentar o codigo la em baixo por algum motivo entao apaguei e colei aqui
//<Image style={styles.img} source={logo}></Image>
export default function Cadastro() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");
    const [email, setEmail] = useState ("");
    const [senha, setSenha] = useState ("");
    const [telefone, setTelefone] = useState ("");

    function cadastrar(){
        //postConta(); //comentado para nao precisar do back
        navigation.navigate("Main");
    }

    async function postConta() {
        const post = {  email, senha, telefone };
        await blogFetch.post("/conta/cadastrar", post);
    }

    return (

        <View style={styles.bodydiv}>
            <ScrollView >
                <View>
                    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.botao}>
                        <Image style={styles.seta} source={require("../imagens/kisspng-brand-logo-black-and-white-triangle-arrow-symbol-5a76c6d1df2c13.8388288415177335859141 (1).png")} />
                    </TouchableOpacity>

                    <View style={styles.topo}>
                        
                        <Text style={styles.textTitle}>Cadastro</Text>
                    </View>

                    <Text style={styles.txt}> Digite seu Email:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setEmail}
                        value={email}
                        placeholder="Email" 
                    />

                    <Text style={styles.txt}> Digite sua Senha:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setSenha}
                        value={senha}
                        placeholder="Senha" 
                        secureTextEntry={true}
                    />

                    <Text style={styles.txt}> Digite seu Telefone:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setTelefone}
                        value={telefone}
                        placeholder="Telefone"
                        //secureTextEntry={true}
                    />

                    <View style={styles.div}>

                        <TouchableOpacity
                            style={styles.buttonAcessar1}
                            onPress={() => cadastrar()}
                        >
                            <Text style={styles.textButtonAcessar}>Confimar</Text>
                        </TouchableOpacity>

                        <TouchableOpacity
                            style={styles.buttonAcessar2}
                            onPress={() => navigation.navigate("Main")}
                        >
                            <Text style={styles.textButtonAcessar}>Voltar</Text>
                        </TouchableOpacity>

                    </View>
                </View>
            </ScrollView>
        </View>

    )


}

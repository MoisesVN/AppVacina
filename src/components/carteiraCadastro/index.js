import React, { useState } from "react";
import { View, Text, TouchableOpacity, TextInput, Image, ScrollView } from "react-native";
import blogFetch from "../../axios/config";
import { useNavigation } from "@react-navigation/native";

import styles from './style';




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

                    <Text style={styles.txt}> Digite seu CPF:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setEmail}
                        value={email}
                        placeholder="CPF" 
                    />

                    <Text style={styles.txt}> Digite seu Numero SUS:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setSenha}
                        value={senha}
                        placeholder="SUS" 
                        secureTextEntry={true}
                    />

                    <Text style={styles.txt}> Digite seu Nome:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setTelefone}
                        value={telefone}
                        placeholder="Nome"
                        //secureTextEntry={true}
                    />
                    <Text style={styles.txt}> Digite sua data de Nacimento:</Text>
                    <TextInput
                        style={styles.textinput}
                        onChangeText={setTelefone}
                        value={telefone}
                        placeholder="data de Nacimento."
                        //secureTextEntry={true}
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


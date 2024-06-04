import { useState } from "react";
import { View, Text, TouchableOpacity, TextInput, Image, ScrollView, Alert } from "react-native";
import blogFetch from "../../axios/config";
import { useNavigation } from "@react-navigation/native";

import styles from './style';

import logo from '../../../assets/logo.webp';


export default function Cadastro() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");
    const [email, setEmail] = useState ("");
    const [senha, setSenha] = useState ("");
    const [telefone, setTelefone] = useState ("");

    const createAlert = () => Alert.alert(
        "Oops!",
        "Verifique se todos os campos estão preenchidos."
    );

    function cadastrar(){
        if (email == "" || senha == "" || telefone == "") {
            createAlert();
        } else {
            postConta();  
        }
    }

    async function postConta() {
        try {   
            const post = {  senha, email, telefone };
            await blogFetch.post("/conta/cadastrar", post);
            navigation.navigate("Main");
        } catch (error) {
            console.log(error);//pode apagar
        }
    }

    return (

        <View style={styles.bodydiv}> 
        
            <ScrollView >
                <View>
                    
                    <Image style={styles.img} source={require('../../../assets/logo.webp')} />
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
                        keyboardType="numeric"
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

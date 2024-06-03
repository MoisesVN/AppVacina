import React, { useState } from "react";
import { View, Text, TouchableOpacity, TextInput, Image, ScrollView } from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

// import logo from '../../../assets/logo.png';

export default function Cadastro() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return (

        <View style={styles.bodydiv}>
            <ScrollView >
                <View>
                    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.botao}>
                        <Image style={styles.seta} source={require("../imagens/kisspng-brand-logo-black-and-white-triangle-arrow-symbol-5a76c6d1df2c13.8388288415177335859141 (1).png")} />
                    </TouchableOpacity>

                    <View style={styles.topo}>

                        <Image style={styles.img} source={logo}></Image>
                        <Text style={styles.textTitle}>Cadastro</Text>
                    </View>

                    <Text style={styles.txt}> Digite seu CPF:</Text>
                    <TextInput
                        style={styles.textinput}
                        placeholder="CPF" />

                    <Text style={styles.txt}> Digite sua Senha:</Text>
                    <TextInput
                        style={styles.textinput}
                        placeholder="Senha" 
                        secureTextEntry={true}
                        />

                    <Text style={styles.txt}> Confirme sua Senha:</Text>
                    <TextInput
                        style={styles.textinput}
                        placeholder="Senha"
                        secureTextEntry={true}
                    />

                    <View style={styles.div}>

                        <TouchableOpacity
                            style={styles.buttonAcessar1}
                            onPress={() => navigation.navigate("Home")}
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

import React, { useState } from "react";
import { View, Text, TouchableOpacity, ScrollView } from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function CarteiraHome() {
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return (
        <ScrollView >
            <View>

                <View>
                    <Text style={styles.textTitle}> minha carteira</Text>

                    <TouchableOpacity
                        style={styles.buttonAcessar}
                        onPress={() => navigation.navigate("Carteira")}
                    >
                        <Text style={styles.textButtonAcessar}>Acessar Minha Carteira</Text>
                    </TouchableOpacity>

                </View>

            </View>
        </ScrollView>
    )


}